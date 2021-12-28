package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leet
 * @description: 外星语言是否排序
 * @author: Tb
 * @create: 2021-12-02 10:02
 **/
public class offer2_34 {
    Map<Character,Integer> map = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i);
        }
        for (int i = 1; i < words.length; i++) {
            if(!isSortStr(words[i-1],words[i])) return false;
        }
        return true;
    }
    public boolean isSortStr(String A,String B){
        int m = A.length();
        int n = B.length();
        int index = 0;
        while (index < m && index < n){
            if(A.charAt(index) == B.charAt(index)){
                index++;
                continue;
            }
            if(map.get(A.charAt(index)) < map.get(B.charAt(index))){
                return true;
            }else {
                return false;
            }
        }
        return index == m;
    }
}
