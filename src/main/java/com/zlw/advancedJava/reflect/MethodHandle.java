package com.zlw.advancedJava.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MethodHandle{

    public static void main(String[] args) throws Exception{
        // 获取指定对象实例
        Class appleFlect = Class.forName("com.zlw.advancedJava.reflect.AppleDemo");
        // 获取构造器
        Constructor constructor = appleFlect.getConstructor();
        // 创建对象
        Object apple = constructor.newInstance();
        //打印对象实例中所有的方法
        getAllMethods(appleFlect,apple);
        // 用method的方法设定值
        useGetMethod(appleFlect,apple);
    }

    private static void useGetMethod(Class appleFlect, Object apple) throws Exception{
        //获得指定的方法(※※※注意set方法，需要加上参数类型的对象实例)
        Method getNumber = appleFlect.getDeclaredMethod("getNumber");
        Method setNumber = appleFlect.getDeclaredMethod("setNumber",Integer.class);
        //无视访问权限
        setNumber.setAccessible(true);
        //设定值
        setNumber.invoke(apple,1);
        //打印出值
        System.out.println("刚刚设定的number值是：" + getNumber.invoke(apple));
    }

    private static void getAllMethods(Class appleFlect, Object apple) throws Exception{
        // 获得所有的methods
        Method[] declaredMethods = appleFlect.getDeclaredMethods();
        int i = 1;
        for (Method method: declaredMethods) {
            System.out.println("public方法全称" + i + ":" + method);
            i++;
        }
        //分界线
        System.out.println("-------------分界线--------------");
        //获得所有public方法
        Method[] methods = appleFlect.getMethods();
        int j = 1;
        for (Method method:methods) {
            System.out.println("所有的方法名" + j + ":" + method.getName());
            j++;
        }
        //分界线
        System.out.println("-------------分界线--------------");
    }
}
