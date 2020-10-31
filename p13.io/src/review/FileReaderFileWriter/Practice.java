package review.FileReaderFileWriter;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 练习：将FileContentCopy复制为FileContentCopy.bak文件
public class Practice {
    @Test
    public void test() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 1.创建输入流和输出流的对象
            fr = new FileReader("FileContentCopy");
            fw = new FileWriter("FileContentCopy.bak", true);

            // 2.数据的读和写操作
            char[] cbuf = new char[1024];
            int len = fr.read(cbuf);
            while (len != -1) {
                // fw.write(cbuf); // 这是错误的，因为读到最后，缓冲区可能存在上一轮读到的数据
                fw.write(cbuf, 0, len);
                len = fr.read(cbuf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
