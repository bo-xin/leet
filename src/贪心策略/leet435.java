package 贪心策略;

import java.util.Arrays;
import java.util.Comparator;

/*
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
注意:

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 */
public class leet435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count = 0;
        int rightEnd = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if(intervals[i][0] >= rightEnd){
                rightEnd = intervals[i][1];
            }else {
                count++;
            }
        }
        return count;
    }
}
