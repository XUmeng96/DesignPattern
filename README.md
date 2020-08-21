# DesignParttern
*------设计模式的理解与简单实现*  

## 一、单例模式
单例模式主要是为了保证使用和返回的对象是唯一的，阻止new操作
### 1. 单例模式的实现
#### a. 饿汉式
 饿：无论是否需要均准备着 static  
 核心实现：私有属性及构造方法；公开提供获取私有属性的方法
 [代码片段](https://github.com/XUmeng96/DesignPattern/blob/master/src/main/java/com/xu/pattern/singleton/HungrySingleton.java)  
 
#### b. 懒汉式
懒：用到头上才会创建，有了就不再创建  
核心实现：私有静态属性=null,方法中创建  
#### c. 双重锁加持的懒汉
优势：解决懒汉式在多线程下并发创建多个对象的问题； 
```java
if(a==null) { Sychronized（a）{ if(a==null)}}
```

#### d. 内部类实现
关键：静态内部类中创建唯一的私有静态外部类的属性；  
外部类的方法实现：返回内部类的静态属性  
#### e. enum 枚举实现
##### I 分析
 enum可以看作是特殊的class类型，enum的declaration会被编译成包含static final属性的final类  
 Enum是abstract class内部包含 final name属性表示定义的constant， final ordinal表示constant的位置，并提供获取name及ordinal的方法
 构造方法为protected Enum(name.ordinal) ,本身重写了toString（获取常量用name()） camparable等方法 valueOf(class, name)方法获取对应的condtant，values()包含所有constant  
 枚举类是可以直接==比较的引用数据类型
 可以为enum编写构造方法、字段和方法
 enum的构造方法要声明为private，字段强烈建议声明为final；
 enum适合用在switch语句中。  

 例：
 ```java
public enum Singleton{
    INSTANCE;
}
```
编译后：
```java
public  final class Singleton  extends  Enum {
    public static final Singleton INSTANCE;
    static {
        INSTANCE = new Singleton("INSTANCE", 0);
        $VALUES =(new Singleton[]{
                INSTANCE
        });
    }
}
```
枚举类比普通类（内部定义static final属性的常量类）的好处是 ：
普通类在做参数比较的时候，不同类型或类中没有定义的常量做校验的时候在编译及运行的时候不会报错；
enum直接限制不可以比较不同类型，以及enum中不包含的值（报错）  


 
 ##### II 实现
 ```java
public enum Singleton{
    INSTANCE;
    public void method(){}
}
// 调用
public static void main (String[] args) {
    Singleton.INSTANCE.method();
    // Singleton.INSTANCE 访问实例
}
```
 ### 2. 单例模式的破坏  
#### a. 反射
#### b. 序列化与反系列化

### 3. 单例模式的应用

参考：
https://www.liaoxuefeng.com/wiki/1252599548343744/1260473188087424  
https://swsmile.info/2019/03/26/%E3%80%90Java%E3%80%91%E6%9E%9A%E4%B8%BE%E5%AE%9E%E7%8E%B0%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F/