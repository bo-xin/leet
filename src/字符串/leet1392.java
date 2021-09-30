package 字符串;

public class leet1392 {
    public String longestPrefix(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] next = new int[n];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < n; i++) {
            while (j != -1 && cs[j+1] != cs[i]){
                j = next[j];
            }
            if(cs[j+1] == cs[i]){
                j++;
            }
            next[i] = j;
        }
        return s.substring(0,next[n-1]+1);
    }
}
