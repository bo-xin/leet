package 剑指offer;

import java.util.*;

/**
 * @program: leet
 * @description: 变位词组
 * @author: Tb
 * @create: 2021-12-02 09:44
 **/
public class offer2_33 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new LinkedList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String s = new String(tmp);
            List<String> list = map.getOrDefault(s,new LinkedList<>());
            list.add(str);
            map.put(s,list);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
