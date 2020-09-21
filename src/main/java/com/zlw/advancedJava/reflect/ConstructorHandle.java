package com.zlw.advancedJava.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ConstructorHandle {

    public static void main(String[] args) throws Exception{
        System.out.println("无参构造器处理开始:");
        //获取指定实例对象
        Class appleFlect = Class.forName("com.zlw.advancedJava.reflect.AppleDemo");
        //获取无参构造器
        Constructor constructor = appleFlect.getConstructor();
        //创建对象
        Object apple = constructor.newInstance();
        //用Method的方法赋值
        Method setPrice = appleFlect.getDeclaredMethod("setPrice", Integer.class);
        Method getPrice = appleFlect.getDeclaredMethod("getPrice");
        setPrice.setAccessible(true);
        setPrice.invoke(apple,13);
        System.out.println("price：" + getPrice.invoke(apple));

        //用filed的方法辅助
        Field number = appleFlect.getDeclaredField("number");
        number.setAccessible(true);
        number.set(apple,14);
        System.out.println("number:" + number.get(apple));
        //分界线
        System.out.println("-------------分界线--------------");
        System.out.println("有参构造器处理开始:");
        constructorWithParam(appleFlect);
    }

    //需要注意的是，构造器只能定义public参数
    private static void constructorWithParam(Class appleFlect) throws Exception{
        //获取有参构造器
        Constructor constructor = appleFlect.getConstructor(Integer.class,Integer.class);
        constructor.setAccessible(true);
        //创建对象
        Object apple = constructor.newInstance(13,14);
        //打印结果
        System.out.println("publicPrice:" + appleFlect.getDeclaredField("publicPrice").get(apple));
        System.out.println("publicNumber:" + appleFlect.getDeclaredField("publicNumber").get(apple));
        //分界线
        System.out.println("-------------分界线--------------");

    }

}
