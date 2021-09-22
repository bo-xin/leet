package JavaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class fastCopyNIO {
    public static void fastCopy(String src, String dest) throws IOException {
        /* 获得源文件的输入字节流 */
        FileInputStream fin = new FileInputStream(src);
        /* 获取输入字节流的文件通道 */
        FileChannel fcin = fin.getChannel();
        // 获取目标文件的输出字符流
        FileOutputStream fout = new FileOutputStream(dest);
        // 获取输出字节流的通道
        FileChannel fcout = fout.getChannel();
        //为缓冲区分配1024个字符
        ByteBuffer buffer = ByteBuffer.allocateDirect(1224);
        while(true){
            //从输入通道中读取数据到缓冲区
            int r = fcin.read(buffer);

            // read（）返回-1 表示EOF
            if(r == -1) break;

            //切换读写
            buffer.flip();

            //把缓冲区内容写入输出文件中
            fcout.write(buffer);
            //清空缓冲区
            buffer.clear();
        }
    }
}
