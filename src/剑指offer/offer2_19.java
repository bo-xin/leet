package 剑指offer;

/**
 * @program: leet
 * @description: 最多删除一个字符得到回文
 * @author: Tb
 * @create: 2021-11-28 11:27
 **/
public class offer2_19 {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while (l < r){
            if(s.charAt(l) != s.charAt(r)){
                return helper(s,l+1,r) || helper(s,l,r-1);
            }
            l++;
            r--;
        }
        return true;
    }
    public boolean helper(String s,int l,int r){
        while (l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
