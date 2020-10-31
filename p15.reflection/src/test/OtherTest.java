package test;


import model.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public class OtherTest {

    // 获取构造器结构
    @Test
    public void test1() {
        Class clazz = Person.class;
        // getConstructors(): 获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
            /*
             * public model.Person()
             */
        }

        System.out.println();

        // getDeclaredConstructors(): 获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
            /*
             * model.Person(java.lang.String,int)
             * private model.Person(java.lang.String)
             * public model.Person()
             */
        }
    }


    // 获取运行时类的父类
    @Test
    public void test2() {
        Class clazz = Person.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass); // class model.Creature

    }

    // 获取运行时类的带泛型的父类
    @Test
    public void test3() {
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass); // model.Creature<java.lang.String>
    }


    // 获取运行时类的带泛型的父类的泛型
    @Test
    public void test4() {
        Class clazz = Person.class;
        // 获取父类泛型类型：Type getGenericSuperclass()
        Type genericSuperclass = clazz.getGenericSuperclass();
        // 泛型类型：ParameterizedType
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        // 获取实际的泛型类型参数数组：getActualTypeArguments()
        Type[] actualTypeArguments = paramType.getActualTypeArguments();

        // System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class) actualTypeArguments[0]).getName()); // java.lang.String
    }


    // 获取运行时类实现的接口
    @Test
    public void test5() {
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
            /*
             * interface java.lang.Comparable
             * interface model.MyInterface
             */
        }

        System.out.println();

        // 获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println(c); // interface java.io.Serializable
        }
    }


    // 获取运行时类所在的包
    @Test
    public void test6() {
        Class clazz = Person.class;
        Package pack = clazz.getPackage();
        System.out.println(pack); // package model
    }


    // 获取运行时类声明的注解
    @Test
    public void test7() {
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annos : annotations) {
            System.out.println(annos); // @model.MyAnnotation(value=hi)
        }
    }
}
