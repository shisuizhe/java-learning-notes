package p15Abstract;

/*
 * 1. abstract: 抽象的
 *
 * 2. abstract 可以用来修饰的结构：类、方法
 *
 * 3. abstract修饰类：抽象类
 * 		> 此类不能实例化
 *      > 抽象类中一定有构造器，便于子类实例化时调用（涉及：子类对象实例化的全过程）
 *      > 开发中，都会提供抽象类的子类，让子类对象实例化，完成相关的操作
 *
 * 4. abstract修饰方法：抽象方法
 * 		> 抽象方法只有方法的声明，没有方法体
 * 		> 包含抽象方法的类，一定是一个抽象类。反之，抽象类中可以没有抽象方法的。
 *      > 若子类重写了父类中的所有的抽象方法后，此子类方可实例化
 *      > 若子类没有重写父类中的所有的抽象方法，则此子类也是一个抽象类，需要使用abstract修饰
 *
 * abstract使用上的注意点：
 *      1. abstract不能修饰变量、代码块、构造器
 *      2. abstract不能用来修饰私有方法、静态方法、final的方法、final的类
 */
public class Abstract1 {
    public static void main(String[] args) {
        // 一旦类抽象了，就不可实例化
        // Creature c = new Creature();

        Student s = new Student();
        s.eat();    // 学生多吃有营养的食物
        s.breath(); // 学生应该呼吸新鲜的没有雾霾的空气
    }
}

abstract class Creature {
    public abstract void breath();
}

abstract class Person extends Creature {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 抽象方法
    public abstract void eat();
}

class Student extends Person {
    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    public void eat() {
        System.out.println("学生多吃有营养的食物");
    }

    @Override
    public void breath() {
        System.out.println("学生应该呼吸新鲜的没有雾霾的空气");
    }
}