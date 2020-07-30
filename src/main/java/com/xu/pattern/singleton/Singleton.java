package com.xu.pattern.singleton;



public class Singleton {
}
/**
 * 饿汉
 */
class HungrySingleton {
    private static HungrySingleton hs = new HungrySingleton();
    // 或者用静态代码块

    private HungrySingleton(){}

    public static HungrySingleton getInstance() {
        return hs;
    }
}
    /**
     *     懒汉 lazy
     *     问题：多线程下可能创建多个实例，线程不安全
     *     改良1：getInstance方法加synchronized  问题：效率太低，其实实例化只要一次，其余return即可；但每次都要同步（锁校验）
     *     改良2-错误思路：在判断 if(ls == null)后 对类对象+锁
     *     即 synchronized(LazySingleton.class) { new... } 同基础懒汉 线程不安全
     */
class LazySingleton{
    private static LazySingleton ls = null;

    private  LazySingleton(){}

    public static LazySingleton getInstance(){
        if(ls == null) {
            ls = new LazySingleton();
        }
            return ls;

    }

}

/**
 * 双重锁
 * 本质是做两次判断-双重判断+锁
 */
class DoubleCheckSingleton{
    private static  DoubleCheckSingleton dcs = null;
    private DoubleCheckSingleton(){}

    public static DoubleCheckSingleton getInstance(){
        if(dcs == null){
            synchronized(DoubleCheckSingleton.class){
                 if(dcs == null) {
                        dcs = new DoubleCheckSingleton();
                    }
            }
        }

        return dcs;
    }
}

/**
 * 静态内部类：外部不可访问的一个类，又将实例作为内部类的属性；
 * 与饿汉类似（类装载机制保证实例初始化时一个线程），但静态内部类当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时才装载
 * 惰性初始化（Lazy-Initialazation）
 */
class InnerClassSingleton{
    private InnerClassSingleton(){}

    private static class SingletonHolder{
        private static InnerClassSingleton ics = new InnerClassSingleton(); // 一定是静态属性，否则无法直接调用SingletonHolder.ics;
    }
    public static InnerClassSingleton getInstance(){

        return SingletonHolder.ics;
    }
}

/**
 * 枚举实现单例
 * 依照枚举本身的底层特性
 */
enum EnumSingleton{
    INSTANCE;

    private  EnumSingleton(){}

    public void getInstance(){}

}