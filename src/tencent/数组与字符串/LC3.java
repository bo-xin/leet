package tencent.数组与字符串;

public class LC3 {
    public static void main(String[] args) {
        System.out.println(new LC3().longestPalindrome("ccc"));
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        String ans = new String();
        int start =0,end =0;
        for (int i = 0; i < n; i++) {
            int long1 = longest(cs,i,i);
            int long2 = longest(cs,i,i+1);
            int len = Math.max(long1, long2);
            if(len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int longest(char[] cs, int i,int j){
        int n = cs.length;
        while (i >=0 && j<n && cs[i]==cs[j]){
                i--;
                j++;
        }
        return j-i-1;
    }
}
