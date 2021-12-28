package 剑指offer;

/**
 * @program: leet
 * @description: 二维子矩阵的和
 * @author: Tb
 * @create: 2021-11-25 10:29
 **/
public class offer2_13 {
    int[][] matrix;
    int[][] sum;
    public offer2_13(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] -sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row1+1][col2+1] - sum[row2+1][col1+1] + sum[row1+1][col1+1];
    }
}
