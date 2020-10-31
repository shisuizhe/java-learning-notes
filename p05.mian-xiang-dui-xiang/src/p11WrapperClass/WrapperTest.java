package p11WrapperClass;

import org.junit.Test;
/*
 * 包装类的使用:
 * 1.java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征
 *
 * 2.掌握的：基本数据类型、包装类、String三者之间的相互转换
 *
 */
public class WrapperTest {

    // String类型 -> 基本数据类型、包装类：调用包装类的parseXxx(String s)
    @Test
    public void test5(){
        String str1 = "123";
        int num2 = Integer.parseInt(str1);
        System.out.println(num2 + 1); // 124
        // 可能会报NumberFormatException
        // int num3 = Integer.parseInt("123abc");
        // System.out.println(num3);

        String str2 = "truE";
        boolean b1 = Boolean.parseBoolean(str2);
        System.out.println(b1); // true
    }

    // 基本数据类型、包装类 -> String类型：调用String重载的valueOf(xx)
    @Test
    public void test4(){
        int num1 = 10;
        // 方式1：连接运算
        String str1 = num1 + "";
        // 方式2：调用String的valueOf(Xxx xxx)
        float f1 = 10.0f;
        String str2 = String.valueOf(f1); // 10.0
        System.out.println(str2);

        Double d1 = new Double(20.0);
        String str3 = String.valueOf(d1);
        System.out.println(str3);   // 20.0
    }

    // JDK 5.0 新特性：自动装箱 与 自动拆箱
    @Test
    public void test3() {
        // 自动装箱：基本数据类型 -> 包装类
        int num1 = 10;
        Integer in1 = num1; // 自动装箱
        System.out.println(in1.toString()); // 10

        boolean b1 = true;
        Boolean b2 = b1;    // 自动装箱
        System.out.println(b2.toString()); // true

        // 自动拆箱：包装类 -> 基本数据类型
        int num3 = in1;     // 自动拆箱
        boolean b3 = b2;    // 自动拆箱
    }

    // 包装类 -> 基本数据类型：调用包装类的xxxValue()
    @Test
    public void test2() {
        Integer in1 = new Integer(12);
        int i1 = in1.intValue();
        System.out.println(i1 + 1);

        Float f1 = new Float(12.3);
        float f2 = f1.floatValue();
        System.out.println(f2 + 1);
    }

    // 基本数据类型 -> 包装类：调用包装类的构造器
    @Test
    public void test1() {
        int num1 = 10;
        // System.out.println(num1.toString()); // 无法调用 toString()
        Integer int1 = new Integer(num1);
        System.out.println(int1.toString()); // 10

        Integer in2 = new Integer("123");
        System.out.println(in2.toString()); // 123

        // 报异常
        // Integer in3 = new Integer("123abc");

        Float f1 = new Float(12.3F);
        Float f2 = new Float("12.3");
        System.out.println(f1); // 12.3
        System.out.println(f2); // 12.3


        Boolean b2 = new Boolean("TrUe");
        System.out.println(b2); // true
        Boolean b3 = new Boolean("true123");
        System.out.println(b3); // false

        Order order = new Order();
        System.out.println(order.isMale);   // false
        System.out.println(order.isFemale); // null
    }
}

class Order {
    boolean isMale;   // 基本数据类型
    Boolean isFemale; // 包装类
}
