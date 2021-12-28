package 剑指offer;

/**
 * @program: leet
 * @description: 有效的变位词
 * @author: Tb
 * @create: 2021-12-01 10:44
 **/
public class offer2_32 {
    public boolean isAnagram(String s, String t) {
        int m = s.length(),n = t.length();
        if(m != n || s.equals(t)) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < m; i++) {
            cnt[s.charAt(i)-'a']++;
            cnt[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(cnt[i] != 0){
                return false;
            }
        }
        return true;
    }
}
