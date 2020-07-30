package com.xu.pattern.singleton;

/**
 * 双重锁
 * 本质是做两次判断-双重判断+锁
 */
public class DoubleCheckSingleton{
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
