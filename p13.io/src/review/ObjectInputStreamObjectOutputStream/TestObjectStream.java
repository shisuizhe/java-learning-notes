package review.ObjectInputStreamObjectOutputStream;

/*
 * 对象流的使用（ObjectInputStream 和 ObjectOutputStream）
 *
 * 作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *
 * 序列化：用 ObjectOutputStream 类保存基本类型数据或对象的机制
 * 反序列化：用 ObjectInputStream 类读取基本类型数据或对象的机制
 *
 * 要想一个java对象是可序列化的，需要满足相应的要求。见Person.java
 *
 * 序列化机制：
 *     对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，
 *     或通过网络将这种二进制流传输到另一个网络节点。当其它程序获取了这种二进制流，就可以恢复成原来的Java对象。
 */

import org.junit.Test;

import java.io.*;

public class TestObjectStream {

    /*
     * 序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
     * 使用 ObjectOutputStream 实现
     *
     * 步骤：
     *     1. 创建一个 ObjectOutputStream 对象
     *     2. 调用 ObjectOutputStream 对象的 writeObject(对象) 方法输出可序列化对象
     *     3. 注意写出一次，操作flush()一次
     */
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("obj.bin"));

            oos.writeObject("你好吗");
            oos.flush();

            oos.writeObject(new Person("AA", 10));
            oos.flush();

            oos.writeObject(new Person("BB", 20, true));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /*
     * 反序列化：将磁盘文件中的对象还原为内存中的一个java对象
     * 使用 ObjectInputStream 来实现
     *
     * 步骤：
     *     1.创建一个 ObjectInputStream 对象
     *     2.调用 ObjectInputStream 对象的 readObject() 方法读取流中的对象
     */
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("obj.bin"));

            String str = (String) ois.readObject();
            Person p1 = (Person) ois.readObject();
            Person p2 = (Person) ois.readObject();

            System.out.println(str); // 你好吗
            System.out.println(p1);  // Person{name='AA', age=10, isMale=false}
            System.out.println(p2);  // Person{name='BB', age=20, isMale=true}

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
