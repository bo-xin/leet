package 双指针;
/*
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class leet680 {
    public boolean validPalindrome(String s) {
        int i = 0;
        int n = s.length();
        int j = n-1;
        while (i<=j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                 if(s.charAt(i) == s.charAt(j-1)){
                     s.substring(j,j);
                 }else {
                     s.substring(i,i);
                 }
            }
            if(s.length()<n-1){
                return false;
            }
        }
        return true;
    }
}
