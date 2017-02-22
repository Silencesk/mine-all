package com.mine.learn.thread;
/**
 * 
 * Description: 任务线程类，依赖于线程池，只要线程池启动，则该线程一致处于运行状态
 * 
 */
public class TaskThread extends Thread {
	private ThreadPoolService service;

	public TaskThread(ThreadPoolService service){
		this.service = service;
	}
	
	@Override
	//任务线程运行，处理任务
	public void run() {
		while(service.isRunning()){
			doTask();
		}
	}
	
	public void doTask(){
		TaskQueue queue = service.getQueue();
		Task task = queue.getTask();
		if(task != null){
			task.setState(Task.State.RUNNING);
			task.deal();
		}
		queue.finishTask(task);
	}
}
