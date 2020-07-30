package com.xu.pattern.singleton;

/**
 * 枚举实现单例
 * 依照枚举本身的底层特性
 */
public enum EnumSingleton{
    INSTANCE;

    private  EnumSingleton(){}

    public void getInstance(){}

}