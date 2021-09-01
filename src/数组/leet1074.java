package 数组;

import java.util.HashMap;
import java.util.Map;

/*
给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。

子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。

如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同

 */
public class leet1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] preSum = new int[n+1][m+1];
        //求数组的前缀和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m ; j++) {
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1]+matrix[i-1][j-1];

            }
        }
        //定义返回值
        int ans = 0;
        //分别便利四个坐标的值，注意右下角的坐标值应该大于等于左上角坐标
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <=m ; j++) {
                for (int k = i; k <=n ; k++) {
                    for (int l = j; l <= m ; l++) {
                        //注意边界条件，求矩阵的和注意边界是否包括
                        if ((preSum[k][l]-preSum[i-1][l]-preSum[k][j-1]+preSum[i-1][j-1])==target) ans++;
                    }
                }
            }
        }
        return ans;
    }

    public int numSubmatrixSumTarget1(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] preSum = new int[n + 1][m + 1];
        //求前缀和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];

            }
        }
        //返回值
        int ans = 0;
        //根据上下边界遍历
        for(int top = 1;top<=n;top++){
            for(int bottom = top;bottom<=n;bottom++){
                //记录当前值
                int cur = 0;
                //声明一个map
                Map<Integer,Integer> map = new HashMap<>();
                for(int r = 1;r<=m;r++){
                    //当前值为记录上下界之间，小于r的矩阵值
                    cur = preSum[bottom][r]-preSum[top-1][r];
                    if(cur == target) ans++;
                    //判断是否有矩阵等于target
                    if(map.containsKey(cur-target)) ans+=map.get(cur-target);
                    map.put(cur,map.getOrDefault(cur,0)+1);
                }
            }
        }
        return ans;
    }
}
