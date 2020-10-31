package p11WrapperClass;

import org.junit.Test;

/*
 * 关于包装类使用的面试题
 *
 */
public class Interview {
    @Test
    public void test1() {
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1); // 1.0  类型提升了，所以是1.0
    }

    @Test
    public void test2() {
        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2); // 1
    }

    @Test
    public void test3() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // false

        // Integer 内部定义了 IntegerCache 结构，IntegerCache 中定义了 Integer[],
        // 保存了从 -128~127 范围的整数。如果我们使用 自动装箱 的方式，给 Integer 赋值的范围
        // 在 -128~127 范围内时，可以直接使用数组中的元素，不用再去 new 了。目的：提高效率。
        Integer m = 1; // 自动装箱方式
        Integer n = 1;
        System.out.println(m == n); // true

        Integer x = 128; // 相当于new了一个Integer对象
        Integer y = 128; // 相当于new了一个Integer对象
        System.out.println(x == y); // false
    }
}
