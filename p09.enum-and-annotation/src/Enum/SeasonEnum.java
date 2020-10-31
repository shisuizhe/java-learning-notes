package Enum;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum 类
 */

public class SeasonEnum {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer.toString()); // Season{name=夏天', desc='夏日炎炎'}

        // values():返回所有的枚举类对象构成的数组
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
            /*
             * Season{name=春天', desc='春暖花开'}
             * 春天在哪里？
             * Season{name=夏天', desc='夏日炎炎'}
             * 宁夏
             * Season{name=秋天', desc='秋高气爽'}
             * 秋天不回来
             * Season{name=冬天', desc='冰天雪地'}
             * 大约在冬季
             */
        }

        // 线程状态枚举类
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
            /*
             * NEW
             * RUNNABLE
             * BLOCKED
             * WAITING
             * TIMED_WAITING
             * TERMINATED
             */
        }

        // valueOf(String objName): 返回枚举类中对象名是objName的对象。
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter); // Season{name=冬天', desc='冰天雪地'}
        winter.show(); // 大约在冬季

        // 如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
        // Season1 winter1 = Season1.valueOf("WINTER1");
    }
}

interface Info {
    void show();
}

// 使用enum关键字枚举类
enum Season1 implements Info {
    // 1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束

    // 1.1 方式一
    // SPRING("春天", "春暖花开"),
    // SUMMER("夏天", "夏日炎炎"),
    // AUTUMN("秋天", "秋高气爽"),
    // WINTER("冬天", "冰天雪地");

    // 1.2 方式二
    SPRING("春天", "春暖花开") {
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    // 2.声明Season对象的属性: private final
    private final String name;
    private final String desc;

    // 3.私有化类的构造器, 并给对象属性赋值
    private Season1(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    // 4.其他诉求1：获取枚举类对象的属性
    public String getname() {
        return name;
    }

    public String getdesc() {
        return desc;
    }

    // 4.其他诉求1：提供toString()
    @Override
    public String toString() {
        return "Season{name=" + name + "', desc='" + desc + "'}";
    }

    @Override
    public void show() {
       System.out.println("这是一个季节");
    }
}
