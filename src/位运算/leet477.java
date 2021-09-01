package 位运算;
/*
两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。

计算一个数组中，任意两个数之间汉明距离的总和。

逐位比较
 */
public class leet477 {
    public int totalHammingDistance(int[] nums) {
       int total = 0;
       int n = nums.length;
        for (int i = 0; i < 30; i++) {
            int c = 0;
            for(int val :nums){
                c+=(val >> i) &1;
            }
            total += c*(n-c);
        }
        return total;
    }
}
