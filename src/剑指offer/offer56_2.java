package 剑指offer;

public class offer56_2 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += num&1;
                num >>>=1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= count[31-i] % 3;
        }
        return res;
    }
}
