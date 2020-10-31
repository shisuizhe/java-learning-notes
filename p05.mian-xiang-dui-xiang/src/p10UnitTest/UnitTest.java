package p10UnitTest;

import org.junit.Test;

/*
 * Java中的JUnit单元测试:
 *
 * 步骤：
 * 1.创建Java类，进行单元测试。
 *   此时的Java类要求：① 此类是public的  ②此类提供公共的无参的构造器
 *
 * 2.此类中声明单元测试方法。
 *   此时的单元测试方法：方法的权限是public,没有返回值，没有形参
 *
 * 3.此单元测试方法上需要声明注解：@Test,并在单元测试类中导入：import org.junit.Test;
 *
 * 4.声明好单元测试方法以后，就可以在方法体内测试相关的代码。
 *
 * 5.写完代码以后，左键双击单元测试方法名，右键：run
 *
 * 说明：
 * 1.如果执行结果没有任何异常：绿条
 * 2.如果执行结果出现异常：红条
 */
public class UnitTest {
    int num = 10;

    @Test
    public void testEquals(){
        String s1 = "MM";
        String s2 = "MM";
        System.out.println(s1.equals(s2)); // true

        System.out.println(num); // 10
        System.out.println(show()); // 20
    }

    public int show(){
        num = 20;
        return num;
    }

    @Test
    public void testToString(){
        String s3 = "CC";
        System.out.println(s3.toString()); // CC
    }
}
