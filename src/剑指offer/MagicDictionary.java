package 剑指offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @program: leet
 * @description: 神奇的字典
 * @author: Tb
 * @create: 2021-12-12 18:10
 **/
public class MagicDictionary {
    Map<Integer, List<String>> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            if(!map.containsKey(s.length())){
                map.put(s.length(),new LinkedList<>());
            }
            map.get(s.length()).add(s);
        }
    }

    public boolean search(String searchWord) {
        if(!map.containsKey(searchWord.length())) return false;
        List<String> list = map.get(searchWord.length());
        for (String s : list) {
            int count = 0;
            for (int i = 0; i < searchWord.length(); i++) {
                if(s.charAt(i) != searchWord.charAt(i)){
                    count++;
                    if(count > 1)break;
                }
            }
            if(count == 1) return true;
        }
        return false;
    }
}
