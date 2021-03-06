package com.mine.learn.jstack;

/**
 * 高cpu消耗的demo，用于jstack定位
 *
 * @author liutao
 * @create 2017-02-28 下午5:11
 */

public class TraceHighIOStd {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread());
                    count();
                }
            }
        });
        thread.start();
    }

    public static void count(){
      int i=0;
      while(i<1000){
        i++;
        System.out.println("current i = "+i);
      }
    }
}
