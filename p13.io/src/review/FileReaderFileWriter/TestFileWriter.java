package review.FileReaderFileWriter;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {

    // 将内容写入一个文本文件（FileWriter）
    @Test
    public void test1() {
        FileWriter fw = null;
        try {
            // 1.提供具体的流

            // 文件不存在则会自动创建

            // 方式1
            // File f1 = new File("FileWriter");
            // fw = new FileWriter(f1);
            // fw = new FileWriter(f1, true); // 以追加方式将内容写入文件

            // 方式2
            // fw = new FileWriter("FileWriter");
            fw = new FileWriter("FileWriter", false);

            // 2.将内容写入文件

            // 一个字符一个字符地写入
            fw.write('你');
            fw.write('好');
            fw.write('吗');
            fw.write('\n'); // 换行
            // 写入一段字符串
            fw.write("I have a dream!\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3.关闭流
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // 将内容写入一个文本文件（FileWriter），使用数组写入文件
    @Test
    public void test2() {
        FileWriter fw = null;
        try {
            // 1.提供具体的流
            fw = new FileWriter("FileWriter", true);

            // 2.将内容写入文件
            String[] contents = {"你好吗", "I hava a dream!"};
            for (String content : contents) {

                // 方式1
                // char[] charArray = content.toCharArray();
                // fw.write(charArray);
                // fw.write('\n');

                // 方式2
                fw.write(content);
                fw.write('\n');
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3.关闭流
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
