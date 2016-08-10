package test;  
  
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.percolate.TransportShardMultiPercolateAction.Response;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.MultiBucketsAggregation;
import org.elasticsearch.search.aggregations.bucket.terms.TermsBuilder;
  
/** 
 * 通过反射机制和单例模式，初始化更加高效的Client 
 * 对ES2.0有效 
 * Created by Jay He on 2015/11/9. 
 */  
public class EsClient {  
//    private static final String CLUSTER_NAME = "cluster_name";  
    public static final String CLUSTER_NAME = "elasticsearch";  
//    private static final String IP = "127.0.0.1";  
    private static final String IP = "192.168.10.71";  
    private static final int PORT = 9300;  
    //1.设置集群名称：默认是elasticsearch，并设置client.transport.sniff为true，使客户端嗅探整个集群状态，把集群中的其他机器IP加入到客户端中  
    
    //对ES1.6有效 
    private static Settings settings = ImmutableSettings 
            .settingsBuilder() 
            .put("cluster.name",CLUSTER_NAME) 
            .put("client.transport.sniff", true) 
            .build(); 
      
    //对ES2.0有效  
   /*private static Settings settings = Settings  
            .settingsBuilder()  
            .put("cluster.name",CLUSTER_NAME)  
            .put("client.transport.sniff", true)  
            .build(); */
    //创建私有对象  
    private static TransportClient client;  
  
    //反射机制创建单例的TransportClient对象  ES1.6版本  
    static {  
        try {  
            Class<?> clazz = Class.forName(TransportClient.class.getName());  
            Constructor<?> constructor = clazz.getDeclaredConstructor(Settings.class);  
            constructor.setAccessible(true);  
            client = (TransportClient) constructor.newInstance(settings);  
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(IP), PORT));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    //ES2.0版本  
//    static {  
//        try {  
//            client = TransportClient.builder().settings(settings).build()  
//                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(IP), PORT));  
//        } catch (UnknownHostException e) {  
//            e.printStackTrace();  
//        }  
//    }  
  
    //取得实例  
    public static synchronized TransportClient getTransportClient(){  
        return client;  
    }  
  
    //为集群添加新的节点  
    public static synchronized void addNode(String name){  
        try {  
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(name),9300));  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        }  
    }  
  
    //删除集群中的某个节点  
    public static synchronized void removeNode(String name){  
        try {  
            client.removeTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(name),9300));  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static void main(String args[]){  
    	//获取链接
//    	getTransportClient();
    	//查询条件
    	BoolQueryBuilder qb = QueryBuilders.boolQuery();
//    	qb.must(QueryBuilders.termQuery("xy.xyname", "何镇宇"));
    	qb.should(QueryBuilders.termQuery("xy.xyname", "何镇宇"));
    	
//    	QueryBuilders qbs = QueryBuilders.matchQuery("xy.xyname", "何镇宇");
    	
    	MatchQueryBuilder mqb = QueryBuilders.matchPhraseQuery("xy.xyname", "何镇宇");
    	
        SearchRequestBuilder requestBuilder = getTransportClient().prepareSearch("megacorp").setTypes("employee");

        //统计
		AbstractAggregationBuilder aggregation = null;
		
		TermsBuilder tBuilder = AggregationBuilders.terms("interests.name");
		tBuilder.field("interests.name");
		aggregation = tBuilder;
//		requestBuilder.setQuery(qb);
		requestBuilder.setQuery(mqb);
		requestBuilder.addAggregation(aggregation);
		 System.out.println(requestBuilder);//查询条件
		SearchResponse response = requestBuilder.execute().actionGet();//执行查询
		
        System.out.println(response);//查询结果
    	Aggregations aggs = response.getAggregations();
        Map<String,Aggregation> aggsMap = aggs.getAsMap();
        System.out.println(aggsMap);
      //查看统计结果
        for(String key : aggsMap.keySet()){
        	Aggregation aggTerms = aggsMap.get(key);
        	//如果
        	if(MultiBucketsAggregation.class.isAssignableFrom(aggTerms.getClass())){
        		 System.out.println(((MultiBucketsAggregation)aggTerms).getBuckets());
    			for(org.elasticsearch.search.aggregations.bucket.MultiBucketsAggregation.Bucket entry :((MultiBucketsAggregation)aggTerms).getBuckets()){
    				 System.out.println(entry.getKey());
    				 System.out.println(entry.getDocCount());
    			}
    		}
        }
        PutMappingRequest mappingRequest = Requests.putMappingRequest("megacorp");
        GetMappingsResponse gm = MappingsResponse
        System.out.println( client.admin().indices().getMappings(arg0));
    }  
  
}  