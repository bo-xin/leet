package 贪心策略;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。

请你重新构造并返回输入数组 people 所表示的队列。
返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 */
public class leet406 {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int m = people[0].length;
        if(people == null || n ==0 || m == 0){
            return new int[0][0];
        }
        Arrays.sort(people,(p1,p2)->p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> queue = new ArrayList<>();
        for(int[] p : people){
            queue.add(p[1],p);
        }
        return queue.toArray(new int[n][m]);
    }
}
