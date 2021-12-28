package 剑指offer;

/**
 * @program: leet
 * @description: 回文子字符串的个数
 * @author: Tb
 * @create: 2021-11-28 11:18
 **/
public class offer2_20 {
    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < 2*n-1; i++) {
            int l = i/2,r = i/2+i%2;
            while (l >=0 && r<n && s.charAt(l) == s.charAt(r)){
                ans++;
                l--;
                r++;
            }
        }
        return ans;
    }
}
