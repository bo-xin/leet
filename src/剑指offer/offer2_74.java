package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leet
 * @description: 合并区间
 * @author: Tb
 * @create: 2021-12-16 10:05
 **/
public class offer2_74 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 0)return new int[0][2];
        List<int[]> merger = new LinkedList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if(merger.size() == 0 || merger.get(merger.size()-1)[1] < start){
                merger.add(new int[]{start,end});
            }else {
                merger.add(new int[]{merger.get(merger.size()-1)[0],Math.max(merger.remove(merger.size()-1)[1],end)});
            }
        }
        return merger.toArray(new int[merger.size()][]);
    }
}
