package com.xu.pattern.singleton;

/**
 * 静态内部类实现：创建外部不可访问的一个类（private），又将实例作为内部类的属性；
 * 与饿汉类似（类装载机制保证实例初始化时一个线程），但静态内部类当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时才装载
 * 惰性初始化（Lazy-Initialazation）
 */
public class  StaticNestedSingleton{
    private StaticNestedSingleton(){}

    private static class SingletonHolder{
        private static StaticNestedSingleton ics = new StaticNestedSingleton(); // 一定是静态属性，否则无法直接调用SingletonHolder.ics;



    }

    public static StaticNestedSingleton getInstance(){
        return SingletonHolder.ics;
    }
}

