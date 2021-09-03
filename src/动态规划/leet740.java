package 动态规划;

public class leet740 {
    public int deleteAndEarn(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for(int val : nums){
            maxVal = Math.max(maxVal,val);
        }
        int[] sums = new int[maxVal+1];
        for (int val : nums){
            sums[val] += val;
        }
        int pre = sums[0];
        int cur = Math.max(sums[0],sums[1]);
        for (int i = 0; i < sums.length; i++) {
            int temp = cur;
            cur = Math.max(cur,sums[i] + pre);
            pre = temp;
        }
        return cur;
    }
}
