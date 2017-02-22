package com.mine.learn.thread;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.mine.learn.thread.Task.State;

/**
 * 
 * Description: 任务队列
 *
 */
public class TaskQueue {
	//任务队列
	public List<Task> queue = new LinkedList<Task>();	//使用链表，任务队列的操作主要是添加于删除
	
	//添加任务
	public synchronized void addTask(Task task){
		if(task != null){
			queue.add(task);
		}
	}
	//获取任务
	public synchronized Task getTask(){
		Iterator<Task> it = queue.iterator();
		while(it.hasNext()){
			Task task = it.next();
			return task;
		}
		return null;
	}
	//删除任务
	public synchronized void finishTask(Task task){
		if(task != null){
			queue.remove(task);
			task.setState(State.FINISHED);
		}
	}
}
