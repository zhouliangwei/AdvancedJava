package com.zlw.advancedJava.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 此类介绍了什么是反射。
 * 反射就是在运行时才知道要操作的类是什么，并且可以在运行时获取类的完整构造，并调用对应的方法。
 */
public class AppleDemo {
    private Integer price;
    private Integer number;
    public Integer publicPrice;
    public Integer publicNumber;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public AppleDemo(Integer publicPrice, Integer publicNumber) {
        this.publicPrice = publicPrice;
        this.publicNumber = publicNumber;
    }


    public AppleDemo() {
    }

    public static void main(String[] args) throws Exception{
        //正常的调用
        AppleDemo appleDemo = new AppleDemo();
        appleDemo.setPrice(4);
        System.out.println(appleDemo.getPrice());

        //分界线
        System.out.println("-------------分界线------------");

        //反射的调用1
        //Class appleFlect1 = appleDemo.getClass();
        //反射的调用2
        //Class appleFlect2 = AppleDemo.class;
        //反射的调用3
        //获取类的对象实例
        Class appleFlect = Class.forName("com.zlw.advancedJava.reflect.AppleDemo");
        //获得AppleDemo的构造器,完成了创建对象前的对象初始化
        Constructor appleConstrutor = appleFlect.getConstructor();
        //创建对象
        Object apple = appleConstrutor.newInstance();
        //获得setPrice方法
        Method setPriceMethod = appleFlect.getMethod("setPrice", Integer.class);
        //设值
        setPriceMethod.invoke(apple, 14);
        //获取getPrice方法
        Method getPriceMethod = appleFlect.getMethod("getPrice");
        //查看price的值
        System.out.println(getPriceMethod.invoke(apple));
    }

}
