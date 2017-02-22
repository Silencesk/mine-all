package com.mine.learn.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SimpleTask extends Task{
	private static Logger logger = LoggerFactory.getLogger(SimpleTask.class);

	public static void main1(String[] args) throws InterruptedException {
		//创建线程池
		ThreadPoolService pool = new ThreadPoolService();
		//启动线程池
		pool.start();
		//线程池执行10次任务
		for(int i=0; i<10; i++){
			pool.runTask(new SimpleTask());
		}
		while(!pool.taskIsAllFinished()){
			int i = 0;
		}
		pool.stop();
	}

	@Override
	public void deal() {
		logger.info("SimpleTask is running");
	}

}
