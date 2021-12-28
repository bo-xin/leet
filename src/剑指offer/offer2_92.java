package 剑指offer;

/**
 * @program: leet
 * @description: 翻转字符
 * @author: Tb
 * @create: 2021-12-22 10:34
 **/
public class offer2_92 {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] ones = new int[n];
        int[] zeros = new int[n];
        ones[0] = s.charAt(0) == '1' ? 0:1;
        zeros[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            int num = s.charAt(i)-'0';
            if(num == 0){
                zeros[i] = zeros[i-1];
                ones[i] = Math.min(zeros[i-1],ones[i-1])+1;
            }
            if(num == 1){
                zeros[i] = zeros[i-1]+1;
                ones[i] = Math.min(zeros[i-1],ones[i-1]);
            }
        }
        return Math.min(zeros[n-1],ones[n-1]);
    }
}
