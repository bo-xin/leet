package 排序;

import java.util.*;

/*
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 */
public class leet451 {
    //桶排序
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character>[] frequencyBucket = new ArrayList[s.length()+1];
        for(char c:map.keySet()){
            int f = map.get(c);
            if(frequencyBucket[f] == null){
                frequencyBucket[f] = new ArrayList<>();
            }
            frequencyBucket[f].add(c);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = frequencyBucket.length-1; i >0 ; i--) {
            if(frequencyBucket[i] == null){
                continue;
            }
            for(char c:frequencyBucket[i]){
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
    //大根堆+hashmap
    public String frequencySort1(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<HashMap.Entry<Character,Integer>> pq = new PriorityQueue<>(new Comparator<HashMap.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.offer(entry);
        }
        StringBuffer sb = new StringBuffer();
        while (!pq.isEmpty()){
            Map.Entry<Character,Integer> entry = pq.poll();
            int value = entry.getValue();
            char c = entry.getKey();
            for (int i = 0; i <value ; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
