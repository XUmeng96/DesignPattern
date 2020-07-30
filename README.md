# DesignParttern
*设计模式的理解与简单实现*
___
## 单例模式
单例模式主要是为了保证使用和返回的对象是唯一的，阻止new操作
### 饿汉式
 饿：无论是否需要均准备着 static  
 核心实现：私有属性及构造方法；公开提供获取私有属性的方法
 代码示例：
 ```$java
 public Class Car{
    priate static car = new Car();
    public Car getCar(){
        return car;
    }
 }
```
### 懒汉式
###双重锁加持的懒汉
### 内部类实现
### enum 枚举实现