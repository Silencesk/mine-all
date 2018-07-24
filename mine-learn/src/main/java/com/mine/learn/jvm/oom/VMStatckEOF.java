package com.mine.learn.jvm.oom;

/**
 * 虚拟机栈与本地方法栈溢出
 *
 * @author liutao
 * @create 2018-01-21 下午10:26
 */

public class VMStatckEOF {
    private static int STACK_DEPTH = 0;

    public void growStack() {
        STACK_DEPTH ++;
        growStack();
    }

    public static void main(String[] args) {
        VMStatckEOF vm = new VMStatckEOF();
        try {
            vm.growStack();
        } catch (Throwable e) {
            /**
             * 未设置栈参数时栈的深度为23506
             * 设置-Xss128k后，128k无法正常启动，vm无法创建
             * -Xss256k，栈深度为3846
             */
            System.err.println(STACK_DEPTH);
            throw e;
        }
    }
}
