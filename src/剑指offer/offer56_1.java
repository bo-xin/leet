package 剑指offer;

public class offer56_1 {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        int m = 1;
        while ((m & res) == 0){
            m <<=1;
        }
        int a =0,b =0;
        for (int num : nums) {
            if((num&m) != 0){
                a ^= num;
            }else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }
}

