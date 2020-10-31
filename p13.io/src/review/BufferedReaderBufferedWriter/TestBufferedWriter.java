package review.BufferedReaderBufferedWriter;

import org.junit.Test;

import java.io.*;

public class TestBufferedWriter {
    @Test
    public void test() {
        FileWriter fw;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("FileWriter", true);
            bw = new BufferedWriter(fw); // 缓冲流：在节点流之上"套"一层

            bw.write('在');
            bw.write('哪');
            bw.write('\n');
            bw.write("在上课\n");

            bw.write("吃了吗");
            bw.newLine();
            bw.write("吃了");
            bw.newLine(); // 这个换行更好，可以实现跨平台的换行，linux -> '\n'  windows -> '\r\n'

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流，只需要关闭高级流
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
