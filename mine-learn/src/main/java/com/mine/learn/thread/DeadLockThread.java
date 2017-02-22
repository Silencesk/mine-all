package com.mine.learn.thread;

public class DeadLockThread implements Runnable{
	private int flag = 1;
	private Object obj1 = new Object();
	private Object obj2 = new Object();
	
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	public void run() {
		System.out.println("线程["+Thread.currentThread().getName()+"]开始启动");
		System.out.println("flag=" + flag);
		if(flag == 1){
			synchronized (obj1) {
				System.out.println("我已锁定obj1，等待0.5s后，锁定obj2");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj2) {
					System.out.println("锁定了obj2");
				}
			}
		}
		if(flag == 2){
			synchronized (obj2) {
				System.out.println("我已锁定obj2，等待0.5后，锁定obj1");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj1) {
					System.out.println("锁定了obj1");
				}
			}
		}
	}

	public static void main1(String[] args) {
		DeadLockThread run1 = new DeadLockThread();
		DeadLockThread run2 = new DeadLockThread();
		run1.setFlag(1);
		run2.setFlag(2);
		
		Thread td1 = new Thread(run1);
		Thread td2 = new Thread(run2);
		
		td1.start();
		td2.start();
	}

}
