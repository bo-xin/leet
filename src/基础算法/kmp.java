package 基础算法;

public class kmp {
    public static void main(String[] args) {
        System.out.println(new kmp().kmp("hello","f"));
    }
    public int kmp(String src,String dest){
        int[] next = next(dest);
        int j = 0;
        int m = src.length();
        int n = dest.length();
        for (int i = 0; i < src.length(); i++) {
            while (j > 0 && src.charAt(i) != dest.charAt(j)){
                j = next[j-1]+1;
                if(n - j + i > m) return -1;
            }
            if(src.charAt(i) == dest.charAt(j)){
                j++;
            }
            if(j == n){
                return i-n+1;
            }
        }
        return -1;
    }
    public int[] next(String str){
        int n = str.length();
        char[] cs = str.toCharArray();
        int[] next = new int[n];
        next[0] = -1;
        int k =-1;
        for (int i = 1; i < n; i++) {
            while (k != -1 && cs[k+1] != cs[i]){
                k = next[k];
            }
            if(cs[k+1] == cs[i]){
                k++;
            }
            next[i] = k;
        }
        return next;
    }
}
