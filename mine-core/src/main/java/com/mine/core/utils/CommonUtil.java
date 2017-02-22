package com.mine.core.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.mine.core.constans.SysConstans;
import com.mine.core.vo.SystemUser;


/**
 * 通用方法类
 * @author wugy
 *
 */
public class CommonUtil {
	
	private CommonUtil(){
		
	}
	
	private static Logger logger = LoggerFactory.getLogger(CommonUtil.class);
			
	public static String app_sys="";
	
	public static final String DNS_SERVIER="uc.belle.net.cn";
	
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 手机号码检测方法
	 * 13(老)号段：130、131、132、133、134、135、136、137、138、139
	 * 15(新)号段：150、151、152、153、154、155、156、157、158、159
	 * 18(3G)号段：180、181、182、183、184、185、186、187、188、189
	 * 
	 * 130：中国联通，GSM
	 * 131：中国联通，GSM
	 * 132：中国联通，GSM
	 * 133：中国联通转给中国电信，CDMA
	 * 134：中国移动，GSM
	 * 135：中国移动，GSM
	 * 136：中国移动，GSM
	 * 137：中国移动，GSM
	 * 138：中国移动，GSM
	 * 139：中国移动，GSM
	 * 
	 * 145：中国联通GSM
	 * 147：中国移动GSM
	 * 
	 * 150：中国移动，GSM
	 * 151：中国移动，GSM
	 * 152：中国联通，暂时未对外放号
	 * 153：中国联通转给中国电信，CDMA
	 * 154：154号段暂时没有分配，估计是因为154的谐音是“要吾死”，这样的手机号码谁敢要啊？
	 * 155：中国联通，GSM
	 * 156：中国联通，GSM
	 * 157：中国移动，GSM
	 * 158：中国移动，GSM
	 * 159：中国移动，GSM
	 * 
	 * 180：中国电信，3G，尚未开始对外放号
	 * 181：3G服务的手机号段，目前没有分配给哪个运营商，也尚未开始对外放号
	 * 182：3G服务的手机号段，目前没有分配给哪个运营商，也尚未开始对外放号
	 * 183：3G服务的手机号段，目前没有分配给哪个运营商，也尚未开始对外放号
	 * 184：3G服务的手机号段，目前没有分配给哪个运营商，也尚未开始对外放号
	 * 185：中国联通，3G，尚未开始对外放号
	 * 186：中国联通，3G，尚未开始对外放号
	 * 187：中国移动，3G，尚未开始对外放号
	 * 188：中国移动，3G，目前TD测试服务在部分城市对外放号
	 * 189：中国电信，3G，CDMA，天翼189，2008年底开始对外放号
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles) {
		if(StringUtils.isBlank(mobiles)){
			return false;
		}
		Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");  
        Matcher m = p.matcher(mobiles);  
        return m.matches();  
	}

	
	/**
	 * 数字检测
	 * @param val
	 * @return
	 */
	public static boolean isNumber(String val) {
		if(StringUtils.isBlank(val)){
			return false;
		}
		if(Pattern.matches("^-{0,1}\\d*\\.{0,1}\\d+$",val)){
			return   true;  
		}
		else{
			return false;
		}
	}
	
	
    
    /**
     * 取得指定长度的随机数字
     * @param length
     * @return
     */
	public static String getRandomCode(int length)
    {
    	char[] codeList= {'0','1', '2', '3', '4', '5', '6', '7', '8', '9' };
    	StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int len=codeList.length;
        for (int i = 0; i < length; i++)
        {
            sb.append(codeList[random.nextInt(len)]);
        }
        return sb.toString();
    }
	
	
	/**
	 * 取得本机IP地址
	 * @return
	 */
	public static String getIPaddr(){
		String ip="";
		try{
			InetAddress addr = InetAddress.getLocalHost();
			ip=addr.getHostAddress();//获得本机IP
			//String address=addr.getHostName();//获得本机名称			
		}
		catch(Exception e){
			System.out.println("getIPaddr() error."+e);
		}
		return ip;
	} 
	
	
	/**
	 * 检测字符串首字母是否为字母
	 * @param val
	 * @return 是返回true;否返回false
	 */
	public static boolean isEnglishWord(String val) {
		if (StringUtils.isBlank(val)) {
			return false;
		}
		char c = val.charAt(0);
		if(((c>='a'&&c<='z') || (c>='A'&&c<='Z'))){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 取出字符串的数字，包括负数
	 * @param s
	 * @return
	 */
	public static String getDigitfromStr(String s) {
		String ret="";
		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			if (Character.isDigit(x) == true || x=='-') {
				ret+=x;
			}
		}
		return ret;
	}
	
	/**
	 * 取出字符串的第一个数字的位置，包括负数
	 * @param s
	 * @return
	 */
	public static int getDigitPosfromStr(String s) {
		int ret=0;
		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			if (Character.isDigit(x) == true || x=='-') {
				ret=i;
				break;
			}
		}
		return ret;
	} 
	
    
    /**
     * 特殊字符转HTML编码
     * @param s
     * @return
     */
	public static String htmlEncode(String s) {
		String ret=s.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">",
				"&gt;").replaceAll("\"", "&quot;");
		return ret;
    }
    
    /**
     * HTML编码解释转码
     * @param s
     * @return
     */
	public static String htmlDecode(String s) {
		String ret = s.replaceAll("&amp;", "&").replaceAll("&lt;", "<")
				.replaceAll("&gt;", ">").replaceAll("&quot;", "\"");
		return ret;
	}
	
    /**
	 * 对字符串进行MD5加密
	 * 
	 * @param plainText
	 *            String
	 * @return String
	 */
	public static String md5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			//e.printStackTrace();
			logger.error("",e);
			return "";
		}
	}
	
	/**
	 * javabean驼峰格式转下划线格式
	 * 如：testName test_name
	 * @param javeBeanStr
	 * @return
	 */
	public static String convertJaveBeanStrToUnderLine(String javeBeanStr){
		StringBuffer  buf = new StringBuffer();
		Pattern p = Pattern.compile("[A-Z]");
        Matcher m = p.matcher(javeBeanStr);
        while(m.find()){
            m.appendReplacement(buf, "_"+m.group(0));
        }
        m.appendTail(buf);
		return buf.toString().toLowerCase();
	}

	/**
	 * 下划线格式转javabean驼峰格式
	 * 如： test_name testName
	 * @param underLineStr
	 * @return
	 */
	public static String convertUnderLineStrToJaveBean(String underLineStr){
		StringBuffer  buf = new StringBuffer(underLineStr);
		Matcher mc = Pattern.compile("_").matcher(underLineStr);
		int i = 0;
		while (mc.find()) {
			int position = mc.end() - (i++);
			buf.replace(position - 1, position + 1,
					buf.substring(position, position + 1).toUpperCase());
		}
		return buf.toString();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void object2MapWithoutNull(Object obj, Map map)
	    		throws IllegalArgumentException, IllegalAccessException {
	    	   
	    		Field[] fields = obj.getClass().getDeclaredFields();
	    		for (int j = 0; j < fields.length; j++) {
	    		    fields[j].setAccessible(true);
		    		
		    		if(fields[j].get(obj) != null){
		    			if((fields[j].get(obj) instanceof Date)){
		    				boolean jfFalge= fields[j].isAnnotationPresent(JSONField.class);
		    				if(jfFalge){
		    					JSONField jf=(JSONField) fields[j].getAnnotation(JSONField.class);
			    				SimpleDateFormat sdf = new SimpleDateFormat( jf.format());
			    				map.put(fields[j].getName(), sdf.format(fields[j].get(obj)));
		    				}else{
		    					SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			    				map.put(fields[j].getName(), sdf.format(fields[j].get(obj)));
		    				}
		    			}else{
		    				map.put(fields[j].getName(), fields[j].get(obj));
		    			}
		    		}else {
		    			map.put(fields[j].getName(),"");
					}
	    		}
	    		
	    		Field[] fields2 = obj.getClass().getSuperclass().getDeclaredFields();
	    		for (int j = 0; j < fields2.length; j++) {
	    			fields2[j].setAccessible(true);
		    		
		    		if(fields2[j].get(obj) != null){
		    			if((fields2[j].get(obj) instanceof Date)){
		    				boolean jfFalge= fields2[j].isAnnotationPresent(JSONField.class);
		    				if(jfFalge){
		    					JSONField jf=(JSONField) fields2[j].getAnnotation(JSONField.class);
			    				SimpleDateFormat sdf = new SimpleDateFormat( jf.format());
			    				map.put(fields2[j].getName(), sdf.format(fields2[j].get(obj)));
		    				}else{
		    					SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			    				map.put(fields2[j].getName(), sdf.format(fields2[j].get(obj)));
		    				}
		    			}else{
		    				map.put(fields2[j].getName(), fields2[j].get(obj));
		    			}
		    		}else {
		    			map.put(fields2[j].getName(),"");
					}
	    		}
	    		
	   }
	 
	  /**
      * 通过反射获得某方法信息
      * @param owner
      * @param methodName
      * @param args
      * @return
      * @throws Exception
      */
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
	      Class ownerClass = owner.getClass();
	      Class[] argsClass = new Class[args.length];
	      for (int i = 0, j = args.length; i < j; i++) {
	          argsClass[i] = args[i].getClass();
	      }
	     Method method = ownerClass.getMethod(methodName, argsClass);
	     return method.invoke(owner, args);
      }
	 
    /**
     * 通过反射设置属性的值
     * @param obj
     * @param fieldname
     * @param clazz
     * @param value
     */
	public static void setFieldValue(Object obj,String fieldname,Class<?> clazz,Object value){
			try {
				Field[] fileds= clazz.getDeclaredFields();
				for(Field field:fileds){
					if(field.getName().equals(fieldname)){
						field = clazz.getDeclaredField(fieldname);
						field.setAccessible(true);
						field.set(obj, value);
					}
				}
			} catch (Exception e) {
				logger.error("",e);
			}
			
	    }
	
	public static void setFieldValue(Object obj,String fieldname,Class<?> clazz,Object value,Field[] fileds){
		try {
			for(Field field:fileds){
				if(field.getName().equals(fieldname)){
					field = clazz.getDeclaredField(fieldname);
					field.setAccessible(true);
					field.set(obj, value);
				}
			}
		} catch (Exception e) {
			logger.error("",e);
		}
		
    }
	/**
	 * 通过反射获得属性的值
	 * @param obj
	 * @param fieldname
	 * @param clazz
	 * @return
	 */
	public static Object getFieldValue(Object obj,String fieldname,Class<?> clazz){
		Field filed;
		try {
			filed = clazz.getDeclaredField(fieldname);
			filed.setAccessible(true);
			return filed.get(obj);
		} catch (Exception e) {
			logger.error("",e);
		} 
		return null;
	}
	
	 /**
     * 设置单个实体的默认属性
     * @param entity
     * @param req
     * @param reqType  0:新增，1：修改
	 * @param clazz
	 * @param date
     */

	public static void setEntityDefaultField(Object entity,int reqType,
    		SystemUser systemUser ,Class<?> clazz,Date date){
		Field[] fileds=clazz.getDeclaredFields();
		if(reqType==0){
			setFieldValue(entity, "createTime", clazz, date,fileds);
			setFieldValue(entity, "creator", clazz,systemUser.getUserName() ,fileds);
		}
		setFieldValue(entity, "modifyTime", clazz, date,fileds);
		setFieldValue(entity, "modifier", clazz, systemUser.getUserName(),fileds);
    }
	
	/**
	 * 首字母大小写转化
	 * @param oldStr
	 * @param changeType 0：首字母转大写，1：首字母转小写
	 * @return
	 */
	public static String changeFirstCharUporLow(String oldStr,int changeType){
		if(changeType==0){
		return  oldStr=oldStr.replaceFirst(oldStr.substring(0, 1)
				,oldStr.substring(0, 1).toUpperCase())  ;
		}else if(changeType==1){
			return  oldStr=oldStr.replaceFirst(oldStr.substring(0, 1)
					,oldStr.substring(0, 1).toLowerCase())  ;
		}
		return oldStr;
	}
	

	/**
	 * 获得对象所有属性名称
	 * @param obj
	 * @return
	 */
	public static List<String> getFieldNames(Object obj){
		List<String> retList=new ArrayList<String>();
		Field[] fields=obj.getClass().getDeclaredFields();
		for(Field field:fields){
			retList.add(field.getName());
		}
		return retList;
	}
	
	/**
	 * 是否存在某属性
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	public static boolean isContainsField(Object obj,String fieldName){
		if(getFieldNames(obj).contains(fieldName)){
			return true;
		}
		return false;
	}
	
	/**
	 * 是否存在某属性
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	public static boolean isContainsField(List<String> fieldList,String fieldName){
		if(fieldList.contains(fieldName)){
			return true;
		}
		return false;
	}
	
	/**
	 * 返回配置环境的host
	 * 如：test.uc.belle.net.cn
	 * 	   st.uc.belle.net.cn
	 * @return
	 */
	public static String getHostUrl() {
		String blf1_host = PropertiesUtils.getPropertieValue("blf1_host");
		if (StringUtils.isNotBlank(blf1_host)){
			return blf1_host;
		}
		return System.getProperty("env") + "." + DNS_SERVIER;
		// return "test"+"."+DNS_SERVIER;
	}
	
	/**
	 * 返回配置环境的host以http://开以
	 * 如：http://test.uc.belle.net.cn
	 * 	   http://st.uc.belle.net.cn
	 * @return
	 */
	public static String getHostUrlWithHttp() {
		return "http://"+CommonUtil.getHostUrl();
	}
	
	/**
	 * 设置属性值 (没有指定类型)
	 * @param obj
	 * @param fieldname
	 * @param clazz
	 * @param value
	 */
	public static void setFieldValue2(Object obj,String fieldname,Class<?> clazz,String value){
		String type;
		try {
			type = obj.getClass().getDeclaredField(fieldname).getGenericType().toString();
			Object ObjValue;
			if(type.indexOf("int")>-1 || type.indexOf("Integer")>-1){
				 ObjValue=Integer.valueOf(value);
			}else if(type.indexOf("double")>-1 || type.indexOf("Double")>-1){
				 ObjValue=Double.valueOf(value);
			}else if(type.indexOf("long")>-1 || type.indexOf("Long")>-1){
				 ObjValue=Long.valueOf(value);
			}else if(type.indexOf("BigDecimal")>-1){
				 ObjValue=new BigDecimal(value);
			}else if(type.indexOf("boolean")>-1 || type.indexOf("Boolean")>-1){
				 ObjValue=Boolean.valueOf(value);
			}else if(type.indexOf("short")>-1 || type.indexOf("Short")>-1){
				 ObjValue=Short.valueOf(value);
			}else{
				ObjValue=String.valueOf(value);
			}
			setFieldValue(obj, fieldname, clazz, ObjValue);
		} catch (Exception e) {
			logger.error("",e);
		} 
		
	}
	
	/**
	 * 获取文件或url扩展名
	 * @param fileName、url
	 * @return
	 */
	public static String getFileExtension(String fileName) {
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		} else {
			return "";
		}
	}
	
	/**
	 * 文件或url扩展名是否为指定的扩展名
	 * @param fileName
	 * @param extension
	 * @return
	 */
	public static boolean isExtension(String fileName,String extension) {
		return (extension.equalsIgnoreCase(CommonUtil.getFileExtension(fileName)))? true:false;
	}
	
	/**
	 * 签名的KEY
	 * @return
	 */
	public static String getSign_key(){
		String sign_key=PropertiesUtils.getPropertieValue("sign_key");
		sign_key=StringUtils.isNotBlank(sign_key)?sign_key:SysConstans.SIGN_KEY;
		return sign_key;
	}
	
	  
    public static String   inputStream2String(InputStream   is)   throws   IOException{
        ByteArrayOutputStream   baos   =   new   ByteArrayOutputStream();
        int   i=-1;
        while((i=is.read())!=-1){
        baos.write(i);
        }
       return   baos.toString();
} 
	

    
	/**
	 * 当前时间离23 59:59还有多少(秒)
	 * @return
	 */
    public static long getCacheAliveTime(){
		Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23); 
        calendar.set(Calendar.MINUTE, 59);       
        calendar.set(Calendar.SECOND, 59);       
        Date timeEnd = calendar.getTime();
        Date timeStart=new Date();
        System.currentTimeMillis();
		return (timeEnd.getTime()-timeStart.getTime())/1000;        
	}
    
    /**
	 * 获得字符串str matcherA与matcherB中间的字符
	 * @param str
	 * @param matcherA
	 * @param matcherB
	 * @return
	 */
	public static String getMiddleChars(String str,String matcherA,String matcherB){
        String regex = matcherA+"(.*)"+matcherB;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
        	return matcher.group(1).trim();
        }
        return "";
	}
	
	/**
	 * 属性拷贝时 设置默认为空 
	 */
	public static void setNullToDefaultValue(){
		ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
		ConvertUtils.register(new LongConverter(null), Long.class);
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new DoubleConverter(null), Double.class);
		ConvertUtils.register(new FloatConverter(null), Float.class);
		ConvertUtils.register(new DateConverter(null), java.util.Date.class);
	}
	
	/**
	 * 将多表数据的json字符串解析为map对象，key为表名，value为表数据
	 * @param json
	 * @return
	 */
	public static Map<String,List<Map<String,Object>>> parseJsonToMultiTables(String json){
		Map<String,List<Map<String,Object>>> map = new HashMap<String,List<Map<String,Object>>>();
		if(StringUtils.isNotEmpty(json)){
			JSONArray jArr = JSON.parseArray(json);
			if(jArr != null && jArr.size() > 0){
				for(int i=0;i<jArr.size();i++){
					JSONObject jObj = jArr.getJSONObject(i);
					if(jObj != null){
						String tableName = jObj.getString("tableName");
						JSONArray valJsonArr = jObj.getJSONArray("tableValue");
						if(valJsonArr != null && valJsonArr.size() > 0){
							List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
							for(int j=0;j<valJsonArr.size();j++){
								JSONObject valJsonObj = valJsonArr.getJSONObject(j);
								Set<Entry<String, Object>> set = valJsonObj.entrySet();
								Iterator<Entry<String, Object>> iterator = set.iterator();
								Map<String,Object> valMap = new HashMap<String,Object>();
								while(iterator.hasNext()){
									Entry<String, Object> entry = iterator.next();
									valMap.put(entry.getKey(), entry.getValue());
								}
								mapList.add(valMap);
							}
							
							map.put(tableName, mapList);
						}
						
					}
				}
			}
		}
		
		return map;
	}
	
	/**
	 * 判断属性是否是数字类型
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	public static boolean fieldIsNumber(Class<?> clazz, String fieldName){
		Field[] fields = clazz.getDeclaredFields();
		for(int i=0;i<fields.length;i++){
			if(fields[i].getName().equals(fieldName)){
				String typeName= fields[i].getType().toString();
				if(isNumberType(typeName))return true;
			}
		}
		Field[] fields1 = clazz.getSuperclass().getDeclaredFields();
		for(int i=0;i<fields1.length;i++){
			if(fields1[i].getName().equals(fieldName)){
				String typeName= fields1[i].getType().toString();
				if(isNumberType(typeName))return true;
			}
		}
		return false;
	}
	
	public static boolean isNumberType(String typeName){
		if(typeName.contains("Integer") || typeName.contains("int") 
				|| typeName.contains("Double") || typeName.contains("double")
				|| typeName.contains("Long") || typeName.contains("long")
				|| typeName.contains("BigDecimal")
				|| typeName.contains("Short") || typeName.contains("short")){
			return true;
		}
		return false;
	}
}