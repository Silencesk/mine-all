package com.mine.learn.thread;

public class TestClient extends Thread {
	private TestNum sn;
	
	public TestClient(TestNum sn){
		this.setSn(sn);
	}
	
	public void run() {
		for(int i=0; i<3; i++){
			System.out.println("thread["+Thread.currentThread().getName()+"] num is "+ sn.getNextNum());
		}
	};
	
	public TestNum getSn() {
		return sn;
	}

	public void setSn(TestNum sn) {
		this.sn = sn;
	}
	
}
