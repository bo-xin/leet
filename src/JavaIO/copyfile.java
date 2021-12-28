package JavaIO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class copyfile {
    public static void copyFile(String src, String dest) throws IOException{
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dest);
        byte[] buffer = new byte[20*1024];
        int cnt;
        while ((cnt = in.read(buffer,0,buffer.length)) != -1){
            out.write(buffer,0,cnt);
        }
        in.close();
        out.close();
    }
    public static void readFileContent(String filePath) throws IOException{
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
