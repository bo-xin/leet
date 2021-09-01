package 位运算;
/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class leet136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num :nums) res ^= num;
        return res;
    }
}
