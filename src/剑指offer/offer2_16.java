package 剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leet
 * @description: 不含重复字符的最长子字符串
 * @author: Tb
 * @create: 2021-11-26 15:51
 **/
public class offer2_16 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int left =0,right = 0;
        while (right < s.length()){
            set.add(s.charAt(right));
            ans = Math.max(ans,set.size());
            right++;
            while (left < right && right<s.length() && set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
        }
        return ans;
    }
}
