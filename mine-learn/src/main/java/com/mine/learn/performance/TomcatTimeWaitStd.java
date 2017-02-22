package com.mine.learn.performance;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mine.core.utils.HttpUtils;

/**
 * @ClassName: TomcatTimeWaitStd<br>
 * @Description: tomcat timewait 过多问题<br>
 * @author liutao<br>
 * @date 2016年9月20日下午2:27:55<br>
 *
 */
@SpringBootApplication
public class TomcatTimeWaitStd{
	int MAX_SIZE = 100;		//最大线程数 
	static Logger logger = LoggerFactory.getLogger(TomcatTimeWaitStd.class);
	private CountDownLatch count;
	
	class MThread extends Thread{
		TomcatTimeWaitStd task;
		String reqUrl;
		CountDownLatch count;
		
		public MThread(TomcatTimeWaitStd task, String reqUrl, CountDownLatch count){
			this.task = task;
			this.reqUrl = reqUrl;
			this.count = count;
		}
		
		@Override
		public void run(){
			try {
				logger.info("<<<<<"+getName()+" started....");
				task.doPost(reqUrl);
				logger.info("<<<<<"+getName()+" ended....");
			} finally {
				count.countDown();
			}
		}
		
	}
	
	void doPost(String reqUrl) {
		Map<String, String> params = new HashMap<String, String>();
		try {
			HttpUtils.post(reqUrl, params );
		} catch (Exception e) {
			logger.error(">>>>error,,,", e);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(TomcatTimeWaitStd.class, args);
		
		
		TomcatTimeWaitStd std = new TomcatTimeWaitStd();
		if(args!=null && args.length>0){
			std.MAX_SIZE = Integer.parseInt(args[0]);
		}
		std.count=new CountDownLatch(std.MAX_SIZE);
		
		
		String reqUrl = "http://dev.uc.belle.net.cn/bl-uc-web/itg_right_list/find.json?sys_menu_moduleId=10110110";
		String reqUrl2 = "http://dev.uc.belle.net.cn/itg_right_list/find.json?sys_menu_moduleId=10110110";
		for(int i=0; i<std.MAX_SIZE; i++){
			std.new MThread(std, reqUrl, std.count).start();
			std.new MThread(std, reqUrl2, std.count).start();
		}
		std.count.await();
		
		logger.error(">>>>request over......");
	}

}
