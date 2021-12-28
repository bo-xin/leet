package 剑指offer;

public class offer39 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ans = nums[0],freq = 0;
        for (int i = 0; i < n; i++) {
            if(freq == 0){
                ans = nums[i];
                freq++;
            }else {
                if(ans == nums[i]){
                    freq++;
                }else {
                    freq--;
                }
            }
        }
        return ans;
    }
}
