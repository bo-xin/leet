package 回溯;

import java.util.List;

public class leet357 {
    public static void main(String[] args) {
        System.out.println(new leet357().countNumbersWithUniqueDigits(2));
    }
    int res = 0;
    StringBuffer sb = new StringBuffer();
    public int countNumbersWithUniqueDigits(int n) {
        boolean[] isVisited = new boolean[10];
        for (int i = 1; i <= n; i++) {
            backtrace(i,isVisited);
        }
        return res+1;
    }
    public void backtrace(int n,boolean[] isVisited){
        if(n == 0){
            if(sb.charAt(0) != '0'){
                res++;
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if(isVisited[i]) continue;
            isVisited[i] = true;
            sb.append(i);
            backtrace(n-1, isVisited);
            sb.deleteCharAt(sb.length()-1);
            isVisited[i] = false;
        }
    }
}
