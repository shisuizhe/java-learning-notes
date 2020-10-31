package concurrency_singleton;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}

// 懒汉式单例
class Singleton {
    private Singleton() {
    }

    private static Singleton instance = null;

    public static Singleton getInstance() {
        // 方式一：效率稍差
        // synchronized (Singleton.class) {
        //     if (instance == null) {
        //         instance = new Singleton();
        //     }
        //     return instance;
        // }

        // 方式二：效率更高
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
