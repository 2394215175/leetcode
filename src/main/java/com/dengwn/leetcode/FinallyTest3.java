package com.dengwn.leetcode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FinallyTest3 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        System.out.println(checkReturn());
//        System.out.println(test3());

        ArrayList<Integer> list = new ArrayList<Integer>(){};
        list.getClass().getMethod("add", Object.class).invoke(list,"asd");
        Type superclass = list.getClass().getGenericSuperclass();
        //getActualTypeArguments 返回确切的泛型参数, 如Map<String, Integer>返回[String, Integer]
        Type type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
        System.out.println(type);//class java.lang.String


    }

    static List<String> test(){
        return new ArrayList<String>();
    }

    public static String test3() {
        StringBuilder b = new StringBuilder("20");

        try {
            System.out.println("try block");

            return b.append(80).toString();
        } catch (Exception e) {

            System.out.println("catch block");
        } finally {

            System.out.println("finally block");
            if (b.length() > 2) {
                System.out.println("b = " + b);
            }
            b.append("1000");
        }

        return "2000";
    }

    public static int checkReturn() {
        int x = 0;
        try {
            // x等于1，此处不返回
            return ++x;
        } finally {
            // 返回的结果是2
            return ++x;
        }
    }

}