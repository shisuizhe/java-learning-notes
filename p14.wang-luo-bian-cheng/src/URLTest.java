import java.net.MalformedURLException;
import java.net.URL;

/*
 * URL网络编程
 * 1.URL:统一资源定位符，对应着互联网的某一资源地址
 * 2.格式：
 *  http://localhost:8080/examples/beauty.jpg?username=Tom
 *  协议   主机名    端口号  资源地址           参数列表
 *
 */

public class URLTest {
    public static void main(String[] args) {
        try {

            URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");

            // 获取该URL的协议名
            System.out.println(url.getProtocol()); // http

            // 获取该URL的主机名
            System.out.println(url.getHost()); // localhost

            // 获取该URL的端口号
            System.out.println(url.getPort()); // 8080

            // 获取该URL的文件路径
            System.out.println(url.getPath()); // /examples/beauty.jpg

            // 获取该URL的文件名
            System.out.println(url.getFile()); // /examples/beauty.jpg?username=Tom

            // 获取该URL的查询名
            System.out.println(url.getQuery()); // username=Tom

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
