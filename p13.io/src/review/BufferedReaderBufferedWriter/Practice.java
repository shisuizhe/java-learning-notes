package review.BufferedReaderBufferedWriter;

import org.junit.Test;

import java.io.*;

// 使用BufferedReader和BufferedWriter实现文本文件的复制
public class Practice {

    @Test
    public void test() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("FileContentCopy"));
            bw = new BufferedWriter(new FileWriter("FileContentCopy.bak"));

            String lineData;
            while ((lineData = br.readLine()) != null) {
                bw.write(lineData); // lineData中不包含换行符
                bw.newLine();       // 提供换行的操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
