package 字符串;

import java.util.*;

/*
给一非空的单词列表，返回前 k 个出现次数最多的单词。

返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class leet692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<String> res = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            res.add(entry.getKey());
        }
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1) == map.get(o2)?o1.compareTo(o2):map.get(o2)-map.get(o1);
            }
        });
        return res.subList(0,k);
    }
}
