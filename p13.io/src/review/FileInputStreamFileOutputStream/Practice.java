package review.FileInputStreamFileOutputStream;

import org.junit.Test;

import java.io.*;

// 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
// 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理

public class Practice {

    @Test
    public void testCopyFile() {
        String srcFile = "img.png";
        String dstFile = "img1.png";
        binaryFileCopy(srcFile, dstFile);
    }

    // 实现二进制文件的复制
    public void binaryFileCopy(String srcFile, String dstFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(dstFile);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
