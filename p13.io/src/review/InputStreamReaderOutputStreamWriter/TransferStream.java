package review.InputStreamReaderOutputStreamWriter;

/*
 * 处理流之二：转换流
 *
 * Java API 提供了两个转换流：
 *     InputStreamReader： 将InputStream转换为Reader （将一个 字节 的输入流转换为 字符 的输入流）
 *     OutputStreamWriter：将Writer转换为OutputStream（将一个 字符 的输出流转换为 字节 的输出流）
 *
 * 作用：提供字节流与字符流之间的转换
 *
 * 解码：字节、字节数组   ---> 字符数组、字符串
 * 编码：字符数组、字符串 ---> 字节、字节数组
 *
 * 字符集：
 *     ASCII      美国标准信息交换码。用一个字节的7位可以表示。
 *     ISO8859-1  拉丁码表。欧洲码表用一个字节的8位表示。
 *     GB2312     中国的中文编码表。最多两个字节编码所有字符
 *     GBK        中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码。
 *     Unicode    国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 *     UTF-8      变长的编码方式，可用1-4个字节来表示一个字符。
 */

import org.junit.Test;

import java.io.*;

public class TransferStream {

    // 读文本文件（出现乱码情况）
    @Test
    public void testRead() {
        FileReader fr;
        BufferedReader br = null;
        try {
            fr = new FileReader("GB2312.txt"); // 因为GB2312.txt是用GB2312编码的，而FileReader默认读取编码UTF-8的文件
            br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                /*
                 * 1234567
                 * �����
                 * I hava a dream!
                 */
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 读文本文件（解决上面乱码情况）
    // InputStreamReader   字节 -> 字符
    @Test
    public void testInputStreamReader() {
        FileInputStream fis;      // 字节流
        InputStreamReader isr;    // 转换流：字节 -> 字符
        BufferedReader br = null;
        try {
            fis = new FileInputStream("GB2312.txt");
            isr = new InputStreamReader(fis, "GB2312"); // 参数2指明了字符集，具体使用哪个字符集，取决于文件保存时使用的字符集
            br = new BufferedReader(isr); // 使用缓冲流包装转换流，因为缓冲流更好用、更高级

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                /*
                 * 1234567
                 * 你好吗
                 * I hava a dream!
                 */
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // 写文本文件（写入文件成功后，用 Notepad++ 打开该文件可以看到编码为 UTF-8，但如果想要 GBK 编码的文件怎么办呢？显然这种方式做不到）
    @Test
    public void testWrite() {
        FileWriter fw;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("default.txt");
            bw = new BufferedWriter(fw);

            bw.write("你好吗");
            bw.newLine();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 写文本文件（指定编码格式写文本文件）
    // OutputStreamWriter  字符 -> 字节
    @Test
    public void testOutputStreamWriter() {
        FileOutputStream fos;
        OutputStreamWriter osw;
        BufferedWriter bw = null;
        try {
            fos = new FileOutputStream("GBK.txt");
            osw = new OutputStreamWriter(fos, "GBK");
            bw = new BufferedWriter(osw);

            bw.write("你好吗");
            bw.newLine();
            bw.write("很好");
            bw.newLine();
            bw.write("吃了没");
            bw.newLine();
            bw.write("吃了");
            bw.newLine();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
