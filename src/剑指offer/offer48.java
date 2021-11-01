package 剑指offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class offer48 {
    public static void main(String[] args) {
        System.out.println(new offer48().lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int right = 0,left =0;
        int ans = 0;
        while (right < n){
            set.add(s.charAt(right));
            right++;
            ans = Math.max(ans,right-left);
            while (right<n && set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
        }
        return ans;
    }
}
