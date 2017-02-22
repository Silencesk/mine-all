package com.mine.simpler.test;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mine.core.util.JsonUtils;
import com.mine.core.util.HttpUtil;

public class BillNoGenerateTest {
	static int M_SIZE=10;
	private CountDownLatch count = new CountDownLatch(2);
	private static Logger logger = LoggerFactory.getLogger(BillNoGenerateTest.class);

	public static void main(String[] args)  throws Exception{
		StopWatch sw = new StopWatch();
		sw.start();
		BillNoGenerateTest test = new BillNoGenerateTest();
		test.testResult();
		logger.debug(">>>>time total " + new Double(sw.getTime())/1000 + "s");
		//System.out.println(test.getBillNo("161001", ""));
	}
	public void testResult() throws Exception{
		String[] arr1 = new String[M_SIZE];
		String[] arr2 = new String[M_SIZE];
		String hostUrl1 = "172.20.50.47:2020";
		String hostUrl2 = "172.20.50.47:2020";
		new MThread(this, arr1, hostUrl1, count).start();
		new MThread(this, arr2, hostUrl2, count).start();
		count.await();
		for(int i=0; i<M_SIZE; i++){
			for(int j=0; j<M_SIZE; j++){
				if(arr1[i].equals(arr2[j])){
					logger.debug("false");
				}
			}
		}
		logger.debug("true");
		
	}
	
	public void testMutiReq(String[] arr, String hostUrl){
		for(int i=0; i<M_SIZE; i++){
			String billNo = getBillNo("999", null, hostUrl);		
			arr[i] = billNo;
			logger.debug(Thread.currentThread().getName() + "_" +billNo);
		}
	}
	
	class MThread extends Thread{
		private BillNoGenerateTest test;
		private String[] arr;
		private String hostUrl;
		private CountDownLatch count;
		
		public MThread(BillNoGenerateTest test, String[] arr, String hostUrl, CountDownLatch count){
			this.test = test;
			this.arr = arr;
			this.hostUrl = hostUrl;
			this.count = count;
		}
		
		@Override
		public void run(){
			try {
				logger.debug("<<<<<"+getName()+" started....");
				test.testMutiReq(arr, hostUrl);
				logger.debug("<<<<<"+getName()+" ended....");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				count.countDown();
			}
		}
	}
	
	public  String getBillNo(String billType, String objJson){
		
		String hostUrl = "localhost";// localhost 	dev.uc.belle.net.cn	 	
		String url = "http://" + hostUrl
				+ "/blf1-mdm-web/bas_system_code/getCodeRuleNo.json";	//getSheetIdCode
		HashMap<String, Object> params = new HashMap<String, Object>();
		String ret;
		params.put("billtypeNo", billType);	//161001-生产计划单
		if (StringUtils.isNotBlank(objJson)) {
			params.put("detail", objJson);
		}
		logger.info(" request mdm getSheetIdCode");
		logger.info("params:" + params);
		logger.info("url:" + url);
		String str = HttpUtil.doGet(url, params);
		logger.info("getSheetIdCode  return :" + str);
		String result = JsonUtils.getValueByKey("result", str);
		String reusltCode = JsonUtils.getValueByKey("resultCode", result);
		if (reusltCode.equals("0")) {
			ret = JsonUtils.getValueByKey("sheetIdCode", str);
			if (StringUtils.isBlank(ret)) {
				logger.error("获取单据失败:", str);
				return null;
			}
			return ret;
		} else {
			logger.error("获取单据失败:", str);
		}
		return null;
	}
	
public static String getBillNo(String billType, String objJson, String hostUrl){
		String url = "http://" + hostUrl
				+ "/blf1-mdm-web/bas_system_code/getSheetIdCode.json";
		HashMap<String, Object> params = new HashMap<String, Object>();
		String ret;
		params.put("billtypeNo", billType);
		if (StringUtils.isNotBlank(objJson)) {
			params.put("detail", objJson);
		}
		logger.info(" request mdm getSheetIdCode");
		logger.info("params:" + params);
		logger.info("url:" + url);
		String str = HttpUtil.doGet(url, params);
		logger.info("getSheetIdCode  return :" + str);
		String result = JsonUtils.getValueByKey("result", str);
		String reusltCode = JsonUtils.getValueByKey("resultCode", result);
		if (reusltCode.equals("0")) {
			ret = JsonUtils.getValueByKey("sheetIdCode", str);
			if (StringUtils.isBlank(ret)) {
				logger.error("获取单据失败:", str);
				return null;
			}
			return ret;
		} else {
			logger.error("获取单据失败:", str);
		}
		return null;
	}
}
