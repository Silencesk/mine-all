package com.mine.learn.source.lang;

public class DogTest {
    static class Dog {
        private String name;

        public Dog(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String getObjectAddress() {
            return super.toString();
        }
    }

    public static void main(String[] args) {
        Dog ga = new Dog("A");
        System.err.println(ga.getObjectAddress());
        System.err.println(ga.getName());
        // java中参数传递为值传递，如果是对象，则传递的是对象用用地址的值
        // 在方法中若对象的内容发生变化，则在方法外，该对象内容也跟着改
        // 如果在方法内部将另外一个不同的对象赋值给该引用，则只是占用了一下变量名，该变量外部的值不会改变
        func(ga);
        System.err.println(ga.getObjectAddress());
        System.err.println(ga.getName());
    }

    public static void func(Dog d) {
        System.err.println("func....");
        System.err.println(d.getObjectAddress());
        d = new Dog("B");
        System.err.println(d.getObjectAddress());
        System.err.println(d.getName());
        System.err.println("func end....");
    }
}
