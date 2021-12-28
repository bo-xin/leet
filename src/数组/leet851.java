package 数组;

import java.util.*;

/**
 * @program: leet
 * @description: 喧闹和富有
 * @author: Tb
 * @create: 2021-12-15 09:31
 **/
public class leet851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>());
        }
        for (int[] rich : richer) {
            map.get(rich[0]).add(rich[1]);
            in[rich[1]]++;
        }
        Deque<Integer> d = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
            if(in[i] == 0)d.addLast(i);
        }
        while (!d.isEmpty()){
            int temp = d.pollFirst();
            for (Integer i : map.get(temp)) {
                if(quiet[ans[temp]] < quiet[ans[i]]) ans[i] = ans[temp];
                if(--in[i] == 0) d.addLast(i);
            }
        }
        return ans;
    }
}
