package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leet
 * @description: 字符串中的所有变位词
 * @author: Tb
 * @create: 2021-11-26 15:50
 **/
public class offer2_15 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        List<Integer> list = new ArrayList<Integer>();
        if (p.length() > s.length()) {
            return list;
        }
        for (int i = 0; i < p.length(); i++) {
            arr1[p.charAt(i) - 'a']++;
            arr2[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(arr1, arr2)) {
            list.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            arr2[s.charAt(i - p.length()) - 'a']--;
            arr2[s.charAt(i) - 'a']++;
            if (Arrays.equals(arr1, arr2)) {
                list.add(i - p.length() + 1);
            }
        }
        return list;
    }
}
