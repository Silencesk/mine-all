package com.mine.simpler.generator;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * 获取配置属性
 * 
 */
public class XmlConfigUtils {
    private static Logger logger = LoggerFactory.getLogger(XmlConfigUtils.class);
    private static HashMap<String, String> configmap = new HashMap<String,String>();
    static{
    	configmap.put("java.lang.Integer","INTEGER");
    	configmap.put("java.math.BigInteger","BIGINT");
    	configmap.put("java.lang.Long","BIGINT");
    	configmap.put("java.lang.Short","SMALLINT");
    	configmap.put("java.lang.Byte","TINYINT");
    	configmap.put("java.lang.Float","FLOAT");
    	configmap.put("java.lang.Double","DOUBLE");
    	configmap.put("java.math.BigDecimal","DECIMAL");
    	configmap.put("java.util.Date","TIMESTAMP");
    	configmap.put("java.sql.Date","TIMESTAMP");
    	configmap.put("java.sql.Timestamp","TIMESTAMP");
    	configmap.put("java.sql.Time","TIMESTAMP");
    	configmap.put("java.lang.Boolean","BOOLEAN");
    	configmap.put("java.lang.String","VARCHAR");
    }

    /**
	 * 单例模式
	 */
	private static XmlConfigUtils instance = new XmlConfigUtils();

	private XmlConfigUtils() {
	}

	public static XmlConfigUtils getInstance() {
		loadXMLConfig("1");
		return instance;
	}
    public static HashMap<String, String> getConfigmap() {
    	if(configmap.size()==0){
    		loadXMLConfig("1");
    	}
		return configmap;
	}

	public static void setConfigmap(HashMap<String, String> configmap) {
		XmlConfigUtils.configmap = configmap;
	}

    
    /**
     * 取出默认资源文件
     * @param obj
     * @return
     * @throws Exception
     */
	public static Document getResourceDocument() throws Exception {
		String fileName=getResourceFilePath()+"config/config.xml";
		SAXReader reader = new SAXReader();
        Document  document = reader.read(new File(fileName));
		return document;
    }
	
	/**
     * 通过fileName取出资源文件
     * @param obj
     * @return
     * @throws Exception
     */
	public static Document getResourceDocumentByFileName(String fileName) throws Exception {
		SAXReader reader = new SAXReader();
        Document  document = reader.read(new File(fileName));
		return document;
    }
	
	/**
     * 取出资源文件的路径
     * @param obj
     * @return
     * @throws Exception
     */
	public static String getResourceFilePath() throws Exception {
    	String path=XmlConfigUtils.class.getClassLoader().getResource("")+"";
    	path=path.replace("file:/", "");
		if(!"/".equals(path.substring(0, 1))){
			path="/"+path;
		}
		logger.info("path:"+path);
		return path;
    }

    /**
     * 将配置文件的name、value读入map
     * @param type 1:config.xml,2:common-system-config.xml
     */
	@SuppressWarnings("rawtypes")
	public static void loadXMLConfig(String type) {
    	logger.info("loadXMLConfig() start.");
        try {
        	 String fileName="src/main/java/com/belle/scm/common/generator/JavaClassToMysqlType.xml";
        	 /*if("1".equals(type)){
        		 fileName=getResourceFilePath()+"/JavaClassToMysqlType.xml";
        	 }*/
        	 
        	 logger.info("loadXMLConfig() fileName:"+fileName);
        	 SAXReader reader = new SAXReader();
             Document  document = reader.read(fileName);
             //Document  document = getResourceDocumentByFileName(fileName);
             Element root=document.getRootElement();
             List content = root.element("tbody").elements("tr");
             String javaclass="",mysqltype="";
             for (Iterator it = content.iterator(); it.hasNext();) {
                Element elm = (Element) it.next();
                List item = elm.elements("td");
                mysqltype=((Element) item.get(0)).elementText("p");
                javaclass=((Element) item.get(3)).elementText("p");
                logger.info("configmap.put(\""+javaclass+"\",\""+mysqltype+"\")");
                configmap.put(javaclass, mysqltype);
             }

        } catch (Exception e) {
            logger.error("loadXMLConfig() error:",e);
        }
        logger.info("loadXMLConfig() end. configmap size:"+configmap.size());
    }

    /**
     * 根据name取得对应的value 返回string
     * @param key
     * @return
     */
    public static String getString(String key) {
    	if(getConfigmap().get(key)!=null){
    		return getConfigmap().get(key).toString();
    	}
    	else{
    		return "";
    	}
    }
    
    /**
     *  根据name取得对应的value 返回boolean
     * @param key
     * @return boolean
     */
    public static boolean getBoolean(String key) {
    	return Boolean.parseBoolean(getString(key));
    }
    
    /**
     *  根据name取得对应的value 返回int
     *  int
     */
    public static int getInt(String key) {
    	return Integer.parseInt(getString(key));
    }
    
    /**
     * 根据name取得对应的value
     * @param name
     * @return
     */
    public static String getVlaue(String name) {
        return getString(name);
    }
    
    public static void main(String[] args) {
		try {
			//new CommonConfigUtils().init();
			logger.info("getContent() start.");
			XmlConfigUtils.getInstance();
			logger.info(configmap.toString());
		} catch (Exception e) {
			 logger.info("getContent() error:",e);
		}
		;
	}

}
