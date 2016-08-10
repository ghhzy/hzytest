package test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * @version V5.0
 * @author Admin
 * @date   2015-7-25
 */
public class Regex {

    /**
     * @param args
     * @author Admin
     * @date 2015-7-25
     */

    public static void main(String[] args) {
        /*Pattern pattern = Pattern.compile("b*g");
        Matcher matcher = pattern.matcher("bbg");
        System.out.println(matcher.matches());
        System.out.println(pattern.matches("b*g","bbg"));
        //验证邮政编码
        System.out.println(pattern.matches("[0-9]{6}", "200038"));
        System.out.println(pattern.matches("//d{6}", "200038"));
        //验证电话号码
        System.out.println(pattern.matches("[0-9]{3,4}//-?[0-9]+", "02178989799"));
        getDate("Nov 10,2009");
        charReplace();
        //验证身份证:判断一个字符串是不是身份证号码，即是否是15或18位数字。
        System.out.println(pattern.matches("^//d{15}|//d{18}$", "123456789009876"));
        getString("D:/dir1/test.txt");*/
//        getChinese("welcome to china,江西奉新,welcome,你!");
        
        
        String regex = "welcometochina江西奉新welcome你";
        String regex1 = "江西奉新2a";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matches("^(.|/n){0,5}$", regex1));
        
        
//        validateEmail("luosijin123@163.com");
    }
    /**
     * 日期提取:提取出月份来
     * @param str
     * @author Admin
     * @date 2015-7-25
     */
    public static void getDate(String str){
        String regEx="([a-zA-Z]+)|//s+[0-9]{1,2},//s*[0-9]{4}";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        if(!matcher.find()){
            System.out.println("日期格式错误!");
            return;
        }
        System.out.println(matcher.group(1));    //分组的索引值是从1开始的，所以取第一个分组的方法是m.group(1)而不是m.group(0)。
    }
    /**
     * 字符替换:本实例为将一个字符串中所有包含一个或多个连续的“a”的地方都替换成“A”。
     * 
     * @author Admin
     * @date 2015-7-25
     */
    public static void charReplace(){
        String regex = "a+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("okaaaa LetmeAseeaaa aa booa");
        String s = matcher.replaceAll("A");
        System.out.println(s);
    }
    /**
     * 字符串提取
     * @param str
     * @author Admin
     * @date 2015-7-25
     */
    public static void getString(String str){
        String regex = ".+/(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(!matcher.find()){
            System.out.println("文件路径格式不正确！");
            return;
        }
        System.out.println(matcher.group(1));
    }
    /**
     * 中文提取
     * @param str
     * @author Admin
     * @date 2015-7-25
     */
    public static void getChinese(String str){
        String regex = "[\u4e00-\u9fa5]+";//[//u4E00-//u9FFF]为汉字 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            sb.append(matcher.group());
        }
        System.out.println(sb);
    }
    /**
     * 验证Email
     * @param email
     * @author Admin
     * @date 2015-7-25
     */
    public static void validateEmail(String email){
        String regex = "[0-9a-zA-Z]+@[0-9a-zA-Z]+//.[0-9a-zA-Z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            System.out.println("这是合法的Email");
        }else{
            System.out.println("这是非法的Email");
        }
    }
}