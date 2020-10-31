package p06FengZhuang;

/*
 * 类的结构之三：构造器（或构造方法、constructor）的使用
 *
 * 一、构造器的作用：
 * 1.创建对象
 * 2.初始化对象的信息
 *
 * 二、说明：
 * 1.如果没有显式的定义类的构造器的话，则系统默认提供一个空参的构造器
 * 2.定义构造器的格式：权限修饰符  类名(形参列表){}
 * 3.一个类中定义的多个构造器，彼此构成重载
 * 4.一旦我们显式的定义了类的构造器之后，系统就不再提供默认的空参构造器
 * 5.一个类中，至少会有一个构造器。
 */
public class GouZaoQi {
    public static void main(String[] args) {
        // 创建对象时，直接触发构造器
        Person p1 = new Person(); // Person().....
        System.out.println(p1.name + " " + p1.age); // null 0

        Person p2 = new Person("pd");
        System.out.println(p2.name + " " + p2.age); // pd 0

        Person p3 = new Person("pd", 18);
        System.out.println(p3.name + " " + p3.age); // pd 18
    }
}

class Person {
    String name;
    int age;

    // 构造器
    public Person() {
        System.out.println("Person().....");
    }
    // 构造器：创建对象同时，初始化其属性
    public Person(String n) {
        name = n;
    }
    // 同上
    public Person(String n, int a) {
        name = n;
        age = a;
    }
}
