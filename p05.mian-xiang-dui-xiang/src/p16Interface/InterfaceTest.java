package p16Interface;

/*
 * 接口的使用
 * 1. 接口使用interface来定义
 *
 * 2. Java中，接口和类是并列的两个结构
 *
 * 3. 如何定义接口：定义接口中的成员
 * 		3.1 JDK7及以前：只能定义全局常量和抽象方法
 * 			>全局常量：public static final的.但是书写时，可以省略不写
 * 			>抽象方法：public abstract的
 * 		3.2 JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法（略）
 *
 * 4. 接口中不能定义构造器的！意味着接口不可以实例化
 *
 * 5. Java开发中，接口通过让类去实现(implements)的方式来使用.
 *    如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
 *    如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类
 *
 * 6. Java类可以实现多个接口 ---> 弥补了Java单继承性的局限性
 *   格式：class AA extends BB implements CC,DD,EE
 *
 * 7. 接口与接口之间可以继承，而且可以多继承
 *
 * 8. 接口的具体使用，体现多态性
 *
 * 9. 接口，实际上可以看做是一种规范
 *
 * 接口的特点：
 *      用interface来定义
 *      接口中的所有成员变量都默认是由public static final修饰的
 *      接口中的所有抽象方法都默认是由public abstract修饰的
 *      接口中没有构造器
 *      接口采用多继承机制
 *      定义Java类的语法格式：先写extends，后写implements
 *      接口的主要用途就是被实现类实现。（面向接口编程）
 *      与继承关系类似，接口与实现类之间存在多态性
 *
 * 面试题：抽象类与接口有哪些异同？
 *    它们都不可以被实例化
 *    抽象类中一定有构造器，而接口中一定不能有构造器
 *
 */
public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);

        Plane plane = new Plane();
        plane.fly(); // 飞机通过引擎起飞了

        Kite2 kite2 = new Kite2();
        kite2.fly(); // 风筝起飞了

        Bullet bullet = new Bullet();
        bullet.fly(); // 子弹高速飞行中...
    }
}

interface Flyable {
    // 全局常量
    public static final int MAX_SPEED = 7900;   // 第一宇宙速度
    int MIN_SPEED = 1;                          // 省略了 public static final

    // 抽象方法
    public abstract void fly();
    void stop();                                // 省略了 public abstract

    // 接口中不能定义构造器！
	// public Flyable(){
	// }
}

interface Attackable {
    void attack();                              // 省略了 public abstract
}

class Plane implements Flyable {
    @Override
    public void fly() {
        System.out.println("飞机通过引擎起飞了");
    }

    @Override
    public void stop() {
        System.out.println("驾驶员减速停止");
    }
}

// 如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类
abstract class Kite1 implements Flyable {
    public Kite1() {
    }
    @Override
    public abstract void fly();
}

// 如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
class Kite2 implements Flyable {
    public Kite2() {
    }
    @Override
    public void fly() {
        System.out.println("风筝起飞了");
    };

    @Override
    public void stop() {
        System.out.println("风筝降落了");
    };
}

interface AA {
    void method1();
}

interface BB {
    void method2();
}

// 接口可以继承其它接口
interface CC extends AA, BB {
}

// 一个类可以实现多个接口
class Bullet extends Object implements Flyable, Attackable, CC {
    @Override
    public void fly() {
        System.out.println("子弹高速飞行中...");
    }

    @Override
    public void stop() {
    }

    @Override
    public void attack() {
    }

    @Override
    public void method1() {
    }

    @Override
    public void method2() {
    }
}
