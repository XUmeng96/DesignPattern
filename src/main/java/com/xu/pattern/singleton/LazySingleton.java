package com.xu.pattern.singleton;

    /**
     *     懒汉 lazy
     *     问题：多线程下可能创建多个实例，线程不安全
     *     改良1：getInstance方法加synchronized  问题：效率太低，其实实例化只要一次，其余return即可；但每次都要同步（锁校验）
     *     改良2-错误思路：在判断 if(ls == null)后 对类对象+锁
     *     即 synchronized(LazySingleton.class) { new... } 同基础懒汉 线程不安全
     */
public class LazySingleton{
    private static LazySingleton ls = null;

    private  LazySingleton(){}

    public static LazySingleton getInstance(){
        if(ls == null) {
            ls = new LazySingleton();
        }
            return ls;

    }

}

