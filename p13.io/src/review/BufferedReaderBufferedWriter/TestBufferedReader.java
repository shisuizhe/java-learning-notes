package review.BufferedReaderBufferedWriter;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestBufferedReader {

    // BufferedReader 自带 defaultCharBufferSize = 8192 的缓冲
    // 当然也可以自己重新创建 buffer，使用 bufferedReader.Read() 方法即可
    @Test
    public void test() {
        FileReader fr;
        BufferedReader br = null;
        try {
            fr = new FileReader("FileReader");
            br = new BufferedReader(fr); // 缓冲流：在节点流之上"套"一层

            String line = br.readLine(); // 读一行内容
            while (line != null) {
                // 处理数据
                System.out.println(line);
                // 继续读
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流，只需要关闭高级流
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
