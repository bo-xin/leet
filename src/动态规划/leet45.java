package 动态规划;

public class leet45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int mostPosition = 0;
        int step = 0;
        for (int i = 0; i < n; i++) {
            mostPosition = Math.max(mostPosition,i + nums[i]);
            if(i == end){
                end = mostPosition;
                step++;
            }
        }
        return step;
    }
}
