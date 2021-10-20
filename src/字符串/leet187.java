package 字符串;

import java.util.*;

public class leet187 {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
    List<List<Integer>> listAll = new ArrayList<>();
    static final int L = 10;
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new LinkedList<>();
        Map<String,Integer> cnt = new HashMap<>();
        int n = s.length();
        for (int i = 0; i + L <= n; i++) {
            String str = s.substring(i,i+L);
            cnt.put(str,cnt.getOrDefault(str,0)+1);
        }
        for (Map.Entry<String,Integer> entry : cnt.entrySet()){
            if(entry.getValue() > 1){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}
