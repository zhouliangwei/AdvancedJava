package com.zlw.advancedJava.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 获得属性名
 */
public class FiledsHandle {

    public static void main(String[] args) throws  Exception {
        //获取指定对象实例
        Class appleFlect = Class.forName("com.zlw.advancedJava.reflect.AppleDemo");
        //获得构造器
        Constructor constructor = appleFlect.getConstructor();
        //创建对象
        Object apple = constructor.newInstance();
        //查看所有的Filed值
        getAllFileds(appleFlect,apple);
        //用Filed的方法设定值
        useGetField(appleFlect,apple);

    }

    private static void getAllFileds(Class appleFlect, Object apple) throws Exception{
        //获取所有属性(不论权限)
        Field[] declaredFields = appleFlect.getDeclaredFields();
        int i = 1;
        for (Field filed:declaredFields) {
            System.out.println("属性名"+ i + ":" + filed.getName());
            i++;
        }
        //分界线
        System.out.println("-------------分界线--------------");
        //获取所有的public属性
        Field[] Fields = appleFlect.getFields();
        int j = 1;
        if(Fields.length == 0){
            System.out.println("这个对象实例里头没有public属性。");
        }
        for (Field filed:Fields) {
            System.out.println("public属性全称"+ j + ":"+ filed);
            j++;
        }
        //分界线
        System.out.println("-------------分界线--------------");
    }

    //定义指定属性
    public static void useGetField(Class appleFlect,Object apple) throws Exception{
        // 获取 price 这个属性（getField这个只能访问public类型的，getDeclaredFiled可以访问任意一个）
        Field price = appleFlect.getDeclaredField("price");
        // 无视访问权限
        price.setAccessible(true);
        // 给指定对象的属性price设定值
        price.set(apple,1);
        // 调用getDeclaredMethod方法去查看刚刚设立的值是否成立
        System.out.println("刚刚设立的price：" + appleFlect.getDeclaredMethod("getPrice").invoke(apple));
    }

}
