package 动态规划;

public class leet413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;
        int[] diff = new int[n-1];
        for (int i = 1; i < n; i++) {
            diff[i-1] = nums[i] - nums[i-1];
        }
        int[] lens = new int[n-1];
        int len = 1;
        int index = 0;
        for (int i = 1; i < n-1; i++) {
            if(diff[i] == diff[i-1]){
                len++;
            }
            lens[index] = len;
            if(diff[i] != diff[i-1]){
                len = 1;
                index++;
            }
        }
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            int value = lens[i] + 1;
            if(value > 2){
                res += (value-1)*(value-2)/2;
            }
        }
        return res;
    }
}
