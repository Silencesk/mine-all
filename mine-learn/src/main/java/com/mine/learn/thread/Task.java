package com.mine.learn.thread;
/**
 * 
 * Description: 任务抽象类，所有由线程池管理的任务都需实现deal方法
 * 
 */
public abstract class Task {
	private State state = State.NEW;	//任务的状态标识
	
	public State getState(){
		return state;
	}
	public void setState(State state){
		this.state = state;
	}
	
	public enum State {
		/*新建*/NEW, /*运行中*/RUNNING, /*已完成*/FINISHED;
	}
	
	//任务处理抽象方法，具体任务实现该方法
	public abstract void deal();
}
