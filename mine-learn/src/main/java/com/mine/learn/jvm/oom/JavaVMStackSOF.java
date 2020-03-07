package com.mine.learn.jvm.oom;

/**
 * VM Args：-Xss128k 栈帧太多，也就是函数调用层级过多）导致。检查是否有死递归的情况~
 */
public class JavaVMStackSOF {
	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length:" + oom.stackLength);
			throw e;
		}
	}
}
