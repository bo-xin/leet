package 字符串;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leet
 * @description: 找到字符串中所有字母异位词
 * @author: Tb
 * @create: 2021-11-28 10:28
 **/
public class leet438 {
    @Test
    public void Test1(){
        System.out.println(findAnagrams("aa","bb"));
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] countS = new int[26];
        int[] countP = new int[26];
        int m = s.length();
        int n = p.length();
        if(n > m) return new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            countP[p.charAt(i)-'a']++;
            countS[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(countP,countS)){
            ans.add(0);
        }
        for (int i = n; i < m; i++) {
            countS[s.charAt(i)-'a']++;
            countS[s.charAt(i-n)-'a']--;
            if(Arrays.equals(countS,countP)){
                ans.add(i-n+1);
            }
        }
        return ans;
    }
}
