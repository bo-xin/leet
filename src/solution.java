import 题解.leet421;

import java.util.Arrays;
import java.util.Scanner;

public class solution {
    public static void main(String[] arg) throws Exception{
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        int in = sc.nextInt();
        for(int i = 0;i<num;i++){
            String str = sc.nextLine();
            if(isAccept(str)){
                System.out.println("Accept");
            }else{
                System.out.println("Wrong");
            }
        }
    }

    public static boolean isAccept(String str){
        char[] cs = str.toCharArray();
        System.out.println(isBig(cs[0]));
        System.out.println(isSmall(cs[0]));
        System.out.println(!isBig(cs[0]) && !isSmall(cs[0]));
        if(!isBig(cs[0]) && !isSmall(cs[0])) return false;
        boolean isHasNum = false;
        for(int i = 1;i < cs.length; i++){
            if(!isBig(cs[i]) &&!isSmall(cs[i]) && !isNum(cs[i])) return false;
            if(isNum(cs[i])) isHasNum = true;
        }
        return isHasNum;
    }
    public static boolean isNum(char c){
        if(c >= '0' && c <= '9') return true;
        return false;
    }
    public static boolean isBig(char c){
        if(c >= 'A' && c <= 'Z') return true;
        return false;
    }
    public static boolean isSmall(char c){
        if(c >= 'a' && c <= 'z') return true;
        return false;
    }
}
