package 贪心策略;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: leet
 * @description: 课程表三
 * @author: Tb
 * @create: 2021-12-14 09:27
 **/
public class leet630 {
    public int scheduleCourse(int[][] courses) {
        /*进行排序，使得截止时间早的在前面*/
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        /*持续时间长的放在堆顶*/
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0] - a[0]);
        /*总的时间*/
        int total = 0;
        /*遍历课程*/
        for (int[] cours : courses) {
            /*判断是否满足入队条件*/
            if(total + cours[0] <= cours[1]){
                total += cours[0];
                pq.offer(cours);
                /*不满足条件并且队中的持续时间大于现在课程的持续时间*/
            }else if(!pq.isEmpty() && pq.peek()[0] > cours[0]){
                total = total - pq.poll()[0] + cours[0];
                pq.offer(cours);
            }
        }
        /*返回*/
        return pq.size();
    }
}
