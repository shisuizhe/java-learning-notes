import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四：使用线程池
 * <p>
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 * corePoolSize：核心池的大小
 * maximumPoolSize：最大线程数
 * keepAliveTime：线程没有任务时最多保持多长时间后会终止
 * <p>
 * <p>
 * JDK 5.0起提供了线程池相关API：ExecutorService 和Executors。
 * ExecutorService：真正的线程池接口。常见子类ThreadPoolExecutor。
 * Executors：工具类、线程池的工厂类，用于创建并返回不同类型的线程池。
 *      Executors.newCachedThreadPool()：创建一个可根据需要创建新线程的线程池
 *      Executors.newFixedThreadPool(n)：创建一个可重用固定线程数的线程池
 *      Executors.newSingleThreadExecutor()：创建一个只有一个线程的线程池
 *      Executors.newScheduledThreadPool(n)：创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行
 *
 * 面试题：创建多线程有几种方式？四种！
 */

// *********************************************************************************
// ***********************************              ********************************
// ***********************************  多线程方式四  ********************************
// ***********************************              ********************************
// *********************************************************************************

class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class NumberThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}


public class ThreadTest3 {
    public static void main(String[] args) {
        // 1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        // System.out.println(service.getClass());

        // 设置线程池的属性
        // service1.setCorePoolSize(15);
        // service1.setMaximumPoolSize();
        // service1.setKeepAliveTime();

        // 2. 执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());    // 适合适用于Runnable
        service.execute(new NumberThread1());   // 适合适用于Runnable
        // service.submit(Callable callable);   // 适合使用于Callable

        // 3.关闭连接池
        service.shutdown();
    }
}
