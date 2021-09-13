package 贪心策略;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leet502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][2];
        //合并两个数组
        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        //对启动资金进行排序
        Arrays.sort(arr,(a,b)->a[0] - b[0]);
        //建立大根堆，根据纯利润
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        //记录当前可以购买哪一个
        int cur = 0;
        //记录次数
        for (int i = 0; i < k; i++) {
            while (cur < n && arr[cur][0] <= w){
                System.out.println(arr[cur][0]+"\t"+arr[cur][1]);
                queue.add(arr[cur][1]);
                cur++;
            }
            //取得当前启动资金小于W的最大利润，栈为空说明没有可以取到的
            if(!queue.isEmpty()){
                w += queue.poll();
            }else {
                break;
            }
        }
        return w;
    }
}
