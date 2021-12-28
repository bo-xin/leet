package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leet
 * @description: 相对名次
 * @author: Tb
 * @create: 2021-12-02 09:31
 **/
public class leet506 {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] tmp = score.clone();
        Arrays.sort(tmp);
        String[] ans = new String[score.length];
        Map<Integer,String> map = new HashMap<>();
        if (n >= 1) {
            map.put(tmp[n-1],"Gold Medal");
        }
        if(n >= 2){
            map.put(tmp[n-2],"Silver Medal");
        }
        if(n >= 3){
            map.put(tmp[n-3],"Bronze Medal");
        }
        for (int i = n-4; i >= 0; i--) {
            map.put(tmp[i],n-i+"");
        }
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(score[i]);
        }
        return ans;
    }
}
