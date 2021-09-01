package 位运算;
/*
给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 */
public class leet260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int num : nums) diff ^= num;
        diff &= -diff;
        int[] ret = new int[2];
        for(int num : nums){
            if((num & diff)==0){
                ret[0] ^= num;
            }else {
                ret[1] ^= num;
            }
        }
        return ret;
    }
}
