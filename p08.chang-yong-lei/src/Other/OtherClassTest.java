package Other;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 其他常用类的使用
 * 1.System
 * 2.Math
 * 3.BigInteger 和 BigDecimal
 */

public class OtherClassTest {
    @Test
    public void test1() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion); // java的version:1.8.0_251

        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome); // java的home:C:\Pd\Java\jdk1.8.0_251\jre

        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName); // os的name:Windows 10

        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion); // os的version:10.0

        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName); // user的name:Administrator

        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome); // user的home:C:\Users\Administrator

        // 当前工作目录
        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir); // user的dir:C:\Users\Administrator\Desktop\learning-java\p08.chang-yong-lei
    }

    @Test
    public void test2() {
        BigInteger bi = new BigInteger("1243324112234324324325235245346567657653");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        // System.out.println(bd.divide(bd2)); // 错误
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));
    }
}
