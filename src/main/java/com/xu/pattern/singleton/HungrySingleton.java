package com.xu.pattern.singleton;

/**
 * 饿汉
 */
public class HungrySingleton {
    private static HungrySingleton hs = new HungrySingleton();
    // 或者用静态代码块

    private HungrySingleton(){}

    public static HungrySingleton getInstance() {
        return hs;
    }
}
