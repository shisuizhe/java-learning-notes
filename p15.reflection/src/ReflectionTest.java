import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    // 反射之前，对于Person的操作
    @Test
    public void test1() {
        // 1.创建Person类的对象
        Person p1 = new Person("Tom", 12);
        // 2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());
        p1.show();
        // 在Person类外部，不可以通过Person类的对象调用其内部私有结构。
        // 比如：name、showNation()以及私有的构造器
    }

    
    // 反射之后，对于Person的操作
    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class;

        // 1.通过反射，创建Person类的对象
        Constructor<Person> cons = clazz.getConstructor(String.class, int.class);
        Person p = cons.newInstance("Tom", 12);
        System.out.println(p.toString()); // Person{name='Tom', age=12}

        // 2.通过反射，调用对象指定的属性、方法
        // 调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p.toString()); // Person{name='Tom', age=10}

        // 调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p); // 你好，我是一个人

        System.out.println("*******************************");

        // 通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        // 调用私有的构造器
        Constructor<Person> cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = cons1.newInstance("Jerry");
        System.out.println(p1); // Person{name='Jerry', age=0}

        // 调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Alex");
        System.out.println(p1); // Person{name='Alex', age=0}

        // 调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国"); // 我的国籍是：中国 // 相当于String nation = p1.showNation("中国")
        System.out.println(nation); // 中国
    }


    /*
     *  关于java.lang.Class类的理解
     *     1.类的加载过程：
     *     程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
     *     接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
     *     加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
     *     运行时类，就作为Class的一个实例。
     *
     *     2.换句话说，Class的实例就对应着一个运行时类。
     *
     *     3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类。
     */
    /*******************************************************************************************
     * ************************                                               ******************
     * ************************  获取Class的实例(四种方法，前三种方式需要掌握)     ******************
     * ************************                                               ******************
     * *****************************************************************************************
     */
    @Test
    public void test3() throws Exception {
        // 方式一：通过运行时类的对象，调用getClass()
        // 前提：已知某个类的实例，调用该实例的getClass()方法获取Class对象
        Person p1 = new Person();
        Class clazz1 = p1.getClass();
        System.out.println(clazz1); // class Person

        // 方式二：调用运行时类的属性：.class
        // 前提：若已知具体的类，通过类的class属性获取Class对象，该方法最为安全可靠，程序性能最高
        Class clazz2 = Person.class;
        System.out.println(clazz2); // class Person

        // 方式三：调用Class的静态方法：forName(String classPath)
        // 前提：已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName()获取Class对象，可能抛出ClassNotFoundException
        Class c = Class.forName("java.lang.String");
        System.out.println(c); // class java.lang.String
        Class clazz3 = Class.forName("Person");
        System.out.println(clazz3); // class Person

        // 方式四：使用类的加载器：ClassLoader  (了解)
        // ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        ClassLoader classLoader = this.getClass().getClassLoader(); // 这里this指本类ReflectionTest
        Class clazz4 = classLoader.loadClass("Person");
        System.out.println(clazz4); // class Person

        System.out.println(clazz1 == clazz2); // true
        System.out.println(clazz1 == clazz3); // true
        System.out.println(clazz1 == clazz4); // true
    }


    // 万事万物皆对象？对象.xxx,File,URL,反射,前端、数据库操作
    // Class实例可以是哪些结构的说明：
    @Test
    public void test4() {
        Class<Object> c1 = Object.class;
        Class<Comparable> c2 = Comparable.class;
        Class<String[]> c3 = String[].class;
        Class<int[][]> c4 = int[][].class;
        Class<ElementType> c5 = ElementType.class;
        Class<Override> c6 = Override.class;
        Class<Integer> c7 = int.class;
        Class<Void> c8 = void.class;
        Class<Class> c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }
}
