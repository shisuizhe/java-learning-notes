package p16Interface;

/*
 * 接口的使用
 * 1.接口使用上也满足多态性
 * 2.接口，实际上就是定义了一种规范
 * 3.开发中，体会面向接口编程！
 *
 */
public class UsbTest {
    public static void main(String[] args) {
        Computer com = new Computer();
        // 1.创建了接口的非匿名实现类的非匿名对象
        Phone phone = new Phone();
        com.transferData(phone);
        /*
         * 手机开始连接
         * 手机断开连接
         */

        // 2.创建了接口的非匿名实现类的匿名对象
        com.transferData(new Printer());
        /*
         * 打印机开始工作
         * 打印机结束工作
         */

        // 3.创建了接口的匿名实现类的非匿名对象
        USB laptop = new USB() {
            @Override
            public void start() {
                System.out.println("笔记本开始工作");
            }

            @Override
            public void stop() {
                System.out.println("笔记本结束工作");
            }
        };
        com.transferData(laptop);
        /*
         * 笔记本开始工作
         * 笔记本结束工作
         */

        // 4. 创建了接口的匿名实现类的匿名对象
        com.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("mp3开始工作");
            }

            @Override
            public void stop() {
                System.out.println("mp3结束工作");
            }
        });
        /*
         * mp3开始工作
         * mp3结束工作
         */
    }
}

class Computer {
    public void transferData(USB usb) { // USB usb = new Flash();
        usb.start();
        // System.out.println("具体传输数据的细节");
        usb.stop();
    }
}

interface USB {
    // 常量：定义了长、宽、最大最小的传输速度等

    void start();
    void stop();
}

class Phone implements USB {
    @Override
    public void start() {
        System.out.println("手机开始连接");
    }

    @Override
    public void stop() {
        System.out.println("手机断开连接");
    }
}

class Printer implements USB {
    @Override
    public void start() {
        System.out.println("打印机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作");
    }
}
