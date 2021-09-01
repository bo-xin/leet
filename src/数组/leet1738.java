package 数组;

import java.util.*;

/*
给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。

矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。

请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）

 */
public class leet1738 {
    public int kthLargestValue(int[][] matrix, int k){
        int nc = matrix.length;
        int nr = matrix[0].length;
        int[][] pre = new int[nc+1][nr+1];
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= nc; i++) {
            for (int j = 1; j <= nr; j++) {
                pre[i][j] = pre[i-1][j]^pre[i][j-1]^pre[i-1][j-1]^matrix[i-1][j-1];
                res.add(pre[i][j]);
                System.out.println(pre[i][j]);
            }
        }
        Collections.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return res.get(k-1);
    }

}
