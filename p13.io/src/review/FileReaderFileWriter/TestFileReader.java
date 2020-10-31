package review.FileReaderFileWriter;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {

    // 读一个文本文件（FileReader），一个一个字符地读
    @Test
    public void test1() {
        FileReader fr = null;
        try {
            // 1.提供具体的流
            // 方式一
            // File f1 = new File("FileReader");
            // fr = new FileReader(f1);
            // 方式二
            fr = new FileReader("FileReader");

            // 2.数据的读入
            // 方式1
            // int data = fr.read();
            // while(data != -1){
            //    System.out.print((char)data);
            //    data = fr.read();
            // }
            // 方式2
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3.关闭流
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // 读一个文本文件（FileReader），进化版，使用缓冲区
    @Test
    public void test2() {
        FileReader fr = null;
        try {
            // 1.提供具体的流
            fr = new FileReader("FileReader");

            // 2.数据的读入
            // read(char[] cbuf): 返回值表示实际读了多少个字符到数组中。如果读到文件末尾，返回-1

            // 方式1
            // char[] cbuf = new char[5];
            // int len = fr.read(cbuf);
            // while (len != -1) {
            //     // 处理读到的数据（读了len个字符）
            //     for (int i = 0; i < len; i++) {
            //         System.out.print(cbuf[i]);
            //     }
            //     // 继续读后面的数据到数组中，直到读完最后一次缓冲区后返回-1
            //     len = fr.read(cbuf);
            // }

            // 方式2
            char[] cbuf = new char[5];
            int len ;
            while ((len = fr.read(cbuf)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3.关闭流
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
