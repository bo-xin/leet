package 周赛;

import java.util.HashMap;
import java.util.Map;

public class leet5868 {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Long> map = new HashMap<>();
        for (int[] rectangle : rectangles){
            double key = (double)(((double)(rectangle[0]))/((double)(rectangle[1])));
            map.put(key,map.getOrDefault(key,(long) 0)+1);
        }
        long ans = 0;
        for (double key : map.keySet()){
            long value = map.get(key);
            if (value > 1){
                ans += value*(value-1)/2;
            }
        }
        return ans;
    }
}
