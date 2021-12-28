package 模拟;

public class leet495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        /*记录返回持续时间*/
        int ans = 0;
        /*对数组进行遍历*/
        for (int i = 0; i < n-1; i++) {
            /*下一次中毒时，已经解毒*/
            if(timeSeries[i]+duration <= timeSeries[i+1]){
                ans += duration;
            }else {
                /*下一次中毒时，还未解毒*/
                ans += timeSeries[i+1]-timeSeries[i];
            }
        }
        /*ans加上最后一次持续时间*/
        return ans + duration;
    }
}
