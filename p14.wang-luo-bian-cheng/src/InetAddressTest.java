import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 *
 * 如何实例化InetAddress:两个方法：getByName(String host) 、 getLocalHost()
 *     两个常用方法：getHostName() / getHostAddress()
 *
 * 端口号与IP地址的组合得出一个网络套接字：Socket
 *
 */

public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1); // /192.168.10.14

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2); // www.baidu.com/183.232.231.174
            // getHostName()
            System.out.println(inet2.getHostName()); // www.baidu.com
            // getHostAddress()
            System.out.println(inet2.getHostAddress()); // 183.232.231.174

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3); // /127.0.0.1

            // 获取本地ip
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4); // pd/192.168.2.101
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
