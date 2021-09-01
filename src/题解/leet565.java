package 题解;
/*
索引从0开始长度为N的数组A，包含0到N - 1的所有整数。
找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。

假设选择索引为i的元素A[i]为S的第一个元素，
S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。

 */
public class leet565 {
    public int arrayNesting(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int cnt =0;
            for(int j = i;nums[j]!=-1;){
                cnt++;
                int t = nums[j];
                nums[j] = -1;
                j=t;
            }
            max = Math.max(max,cnt);
        }
        return max;
    }
}
