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
 * ͨ��������ƺ͵���ģʽ����ʼ�����Ӹ�Ч��Client 
 * ��ES2.0��Ч 
 * Created by Jay He on 2015/11/9. 
 */  
public class EsClient {  
//    private static final String CLUSTER_NAME = "cluster_name";  
    public static final String CLUSTER_NAME = "elasticsearch";  
//    private static final String IP = "127.0.0.1";  
    private static final String IP = "192.168.10.71";  
    private static final int PORT = 9300;  
    //1.���ü�Ⱥ���ƣ�Ĭ����elasticsearch��������client.transport.sniffΪtrue��ʹ�ͻ�����̽������Ⱥ״̬���Ѽ�Ⱥ�е���������IP���뵽�ͻ�����  
    
    //��ES1.6��Ч 
    private static Settings settings = ImmutableSettings 
            .settingsBuilder() 
            .put("cluster.name",CLUSTER_NAME) 
            .put("client.transport.sniff", true) 
            .build(); 
      
    //��ES2.0��Ч  
   /*private static Settings settings = Settings  
            .settingsBuilder()  
            .put("cluster.name",CLUSTER_NAME)  
            .put("client.transport.sniff", true)  
            .build(); */
    //����˽�ж���  
    private static TransportClient client;  
  
    //������ƴ���������TransportClient����  ES1.6�汾  
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
  
    //ES2.0�汾  
//    static {  
//        try {  
//            client = TransportClient.builder().settings(settings).build()  
//                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(IP), PORT));  
//        } catch (UnknownHostException e) {  
//            e.printStackTrace();  
//        }  
//    }  
  
    //ȡ��ʵ��  
    public static synchronized TransportClient getTransportClient(){  
        return client;  
    }  
  
    //Ϊ��Ⱥ����µĽڵ�  
    public static synchronized void addNode(String name){  
        try {  
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(name),9300));  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        }  
    }  
  
    //ɾ����Ⱥ�е�ĳ���ڵ�  
    public static synchronized void removeNode(String name){  
        try {  
            client.removeTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(name),9300));  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static void main(String args[]){  
    	//��ȡ����
//    	getTransportClient();
    	//��ѯ����
    	BoolQueryBuilder qb = QueryBuilders.boolQuery();
//    	qb.must(QueryBuilders.termQuery("xy.xyname", "������"));
    	qb.should(QueryBuilders.termQuery("xy.xyname", "������"));
    	
//    	QueryBuilders qbs = QueryBuilders.matchQuery("xy.xyname", "������");
    	
    	MatchQueryBuilder mqb = QueryBuilders.matchPhraseQuery("xy.xyname", "������");
    	
        SearchRequestBuilder requestBuilder = getTransportClient().prepareSearch("megacorp").setTypes("employee");

        //ͳ��
		AbstractAggregationBuilder aggregation = null;
		
		TermsBuilder tBuilder = AggregationBuilders.terms("interests.name");
		tBuilder.field("interests.name");
		aggregation = tBuilder;
//		requestBuilder.setQuery(qb);
		requestBuilder.setQuery(mqb);
		requestBuilder.addAggregation(aggregation);
		 System.out.println(requestBuilder);//��ѯ����
		SearchResponse response = requestBuilder.execute().actionGet();//ִ�в�ѯ
		
        System.out.println(response);//��ѯ���
    	Aggregations aggs = response.getAggregations();
        Map<String,Aggregation> aggsMap = aggs.getAsMap();
        System.out.println(aggsMap);
      //�鿴ͳ�ƽ��
        for(String key : aggsMap.keySet()){
        	Aggregation aggTerms = aggsMap.get(key);
        	//���
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