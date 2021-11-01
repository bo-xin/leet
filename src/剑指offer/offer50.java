package 剑指offer;

import java.util.*;

public class offer50 {
    public char firstUniqChar(String s) {
        if (s.isEmpty()) return ' ';
        int n = s.length();
        char[] cs = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(cs[i],map.getOrDefault(cs[i],0)+1);
        }
        for (int i = 0; i < n; i++) {
            if(map.get(cs[i]) == 1) return cs[i];
        }
        return ' ';
    }
}
