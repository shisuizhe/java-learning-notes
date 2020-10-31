package p12Static;
/**
 * 单例设计模式：
 * 1. 所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例。
 *
 * 2. 如何实现？
 * 	 饿汉式 vs 懒汉式
 *
 * 3. 区分 饿汉式 和 懒汉式
 *   饿汉式：
 *   	坏处：对象加载时间过长。
 *   	好处：饿汉式是线程安全的
 *
 *   懒汉式：
 *      好处：延迟对象的创建。
 * 		目前的写法坏处：线程不安全。---> 到多线程内容时，再修改
 *
 *
 * 单例(Singleton)设计模式-应用场景：
 *      1.网站的计数器，一般也是单例模式实现，否则难以同步。
 *      2.应用程序的日志应用，一般都使用单例模式实现，这一般是由于共享的日志
 *      3.文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加。
 *      4.数据库连接池的设计一般也是采用单例模式，因为数据库连接是一种数据库资源。
 *      5.项目中，读取配置文件的类，一般也只有一个对象。没有必要每次使用配置文件数据，都生成一个对象去读取。
 *      6.Application 也是单例的典型应用：
 *          6.1Windows的Task Manager (任务管理器)就是很典型的单例模式
 *          6.2Windows的Recycle Bin (回收站)也是典型的单例应用。在整个系统运行过程中，回收站一直维护着仅有的一个实例。
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2); // true

        Singleton1 s3 = Singleton1.getInstance();
        Singleton1 s4 = Singleton1.getInstance();
        System.out.println(s3 == s4); // true
    }
}

// 饿汉式-单例模式
class Singleton {
    // 1.私有化构造器
    private Singleton() {
    }

    // 2.内部提供一个当前类的实例
    // 4.此实例也必须静态化
    private static Singleton single = new Singleton();

    // 3.提供公共的静态的方法，返回当前类的对象
    public static Singleton getInstance() {
        return single;
    }
}

// 懒汉式-单例模式
// 此版本懒汉式单例模式暂时还存在线程安全问题，讲到多线程时，可修复
class Singleton1 {
    private Singleton1() {
    }

    // 声明当前类对象，没有初始化
    private static Singleton1 single;

    public static Singleton1 getInstance() {
        if (single == null) {
            single = new Singleton1();
        }
        return single;
    }
}
