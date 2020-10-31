import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 */
public class ClassLoaderTest {

    // ClassLoader：类加载器作用是用来把类(class)装载进内存的。
    @Test
    public void test1() throws ClassNotFoundException {
        // 最常用的类加载器：系统类加载器或称为应用程序类加载器
        ClassLoader classLoader1 = ClassLoader.getSystemClassLoader();
        ClassLoader classLoader2 = this.getClass().getClassLoader();
        System.out.println(classLoader1 == classLoader2); // true
        System.out.println(classLoader1); // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 系统类加载器的父类是扩展类加载器（负责加载jre/lib/ext目录下的所有jar）
        ClassLoader classLoader3 = classLoader1.getParent();
        System.out.println(classLoader3); // sun.misc.Launcher$ExtClassLoader@8efb846

        // 扩展类加载器的父类是引导类加载器（获取不到，在最底层）
        ClassLoader classLoader4 = classLoader3.getParent();
        System.out.println(classLoader4); // null

        // 类加载器的双亲委派机制：
        // 比如要加载Person类，系统类加载器会先开始准备加载，但是它加载之前必须先让父类加载器加载
        // 扩展类加载器无条件先委派引导类加载器加载这个类

        // 测试当前类由哪个类加载器进行加载
        ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
        System.out.println(classLoader); // null -> 即引导类加载器进行加载
    }


    // 类加载器常用的一个功能：读取配置文件
    @Test
    public void test2() throws Exception {
        Properties props = new Properties();
        // 读取配置文件的方式一：使用字节流FileInputStream（配置文件默认识别为：当前module下）
        // FileInputStream fis = new FileInputStream("jdbc.properties");
        // props.load(fis);

        // 读取配置文件的方式二（推荐使用）：使用ClassLoader（配置文件默认识别为：当前module的src下）
        // ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        props.load(is);

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        System.out.println("user=" + user + " password=" + password); // user=pd password=123
    }
}
