package com.mine.learn.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Description: 线程池类
 * 
 */
public class ThreadPoolService {
	private List<TaskThread> threads = new ArrayList<TaskThread>();
	private TaskQueue queue = new TaskQueue();
	public static final int THREAD_MAX_SIZE = 5;
	private State state = State.NEW;
	
	//线程池初始化
	public ThreadPoolService(){
		for(int i=0; i<THREAD_MAX_SIZE; i++){
			threads.add(new TaskThread(this));
		}
	}
	//线程池启动，需将线程池中所有线程启动
	public void start(){
		for(TaskThread t : threads){
			t.start();
		}
		setState(State.RUNNING);
	}
	//线程池是否运行
	public boolean isRunning(){
		return state.equals(State.RUNNING);
	}
	//运行任务
	public void runTask(Task task){
		queue.addTask(task);
	}
	//任务队列中任务是否都已执行完毕
	public boolean taskIsAllFinished(){
		return queue.queue.size()==0;
	}
	//线程停止
	public void stop(){
		setState(State.TERMINATED);
	}
	//线程池状态处理
	public State getState(){
		return state;
	}
	public void setState(State state){
		this.state = state;
	}
	
	public TaskQueue getQueue() {
		return queue;
	}
	public void setQueue(TaskQueue queue) {
		this.queue = queue;
	}

	public enum State {
		/*新建*/NEW, /*运行中*/RUNNING, /*终止*/TERMINATED;
	}
	
}
