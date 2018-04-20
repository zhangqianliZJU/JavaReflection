package com.zhang;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BadPersonReflection {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        try {
            Class<?> class1 = Class.forName("com.zhang.BadPerson");
            System.out.println(class1);
            Class<?> class2 = BadPerson.class;
            System.out.println(class2);
            System.out.println("class1 == class2?: " + class1.equals(class2));
            System.out.println("Hashcode of class1: " + class1.hashCode());
            System.out.println("Hashcode of class2: " + class2.hashCode());
            BadPerson badPerson = new BadPerson();
            Class<?> class3 = badPerson.getClass();
            System.out.println(class3);
            Object object = new Object();
            System.out.println("HashCode of object: " + object.hashCode());

            Method[] methods = class1.getMethods();
            for (Method e : methods) {
                System.out.println(e);
                System.out.println(e.getModifiers());
            }
            System.out.println("获取接口");
            Class<?>[] interfaces = class1.getInterfaces();
            for (Class<?> e : interfaces) {
                System.out.println(e);
            }
            System.out.println("测试数组是什么类");
            double[] doubleArray = new double[]{1.0, 2.0, 3.0, 4.0};
            Class<?> doubleClass = doubleArray.getClass();
            System.out.println(doubleClass);
            int[] intArray = new int[]{1, 2, 3, 4, 6};
            Class<?> intClass = intArray.getClass();
            System.out.println(intClass);
            System.out.println("整型数组的父类是：" + intClass.getSuperclass());
            Method[] intMethods = intClass.getMethods();
            System.out.println("整型数组的构造器：");
            Constructor<?>[] constructors = intClass.getConstructors();
            for (Constructor<?> e : constructors) {
                System.out.println(e);
            }
            System.out.println("BadPerson的构造器：");
            Constructor<?>[] constructors1 = class1.getConstructors();
            for (Constructor<?> e : constructors1) {
                System.out.println(e);
            }
            System.out.println("整型素组类中包括的方法");
            for (Method e : intMethods) {
                System.out.println(e);
            }
            Field[] fields = class1.getDeclaredFields();
            System.out.println("BadPerson的所有字段：");
            for (Field e : fields) {
                System.out.println(e);
            }
            Object badPerson1 = class1.newInstance();
            BadPerson badPerson2 = (BadPerson) badPerson1;
            badPerson2.setAge("Age 100");
            System.out.println("Age of badPerson2 = " + badPerson2.getAge());

            Field age = class1.getDeclaredField("age");
            age.setAccessible(true);//是否破坏了类的封装原则
            age.set(badPerson2, "age 120");
            System.out.println("Age of badPerson2 = " + badPerson2.getAge());

            Method setName = class1.getDeclaredMethod("setName", String.class);
            setName.setAccessible(false);
            setName.invoke(badPerson2,"whaterver");
            Method getName = class1.getDeclaredMethod("getName");
            System.out.println("name of badperson2 = " + getName.invoke(badPerson2));
            System.out.println("class of int = " + int.class);
            System.out.println("Super class of int = " + int.class.getSuperclass());
            Class<?> intSuperClass = int.class.getSuperclass();
            System.out.println("class of Integer = " + Integer.class);

            Constructor<?> constructor1 = class1.getDeclaredConstructor(String.class,String.class);
            Object newInstance = constructor1.newInstance("100","hahaha");
            BadPerson badPerson3 = (BadPerson) newInstance;
            System.out.println("Id of badPerson3 = " + badPerson3.getId() +"Name of badPerson3 = "+ badPerson3.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e){ e.printStackTrace();}
    }
}
