package 动态规划;

public class leet1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        int[][] sumMat = sumMatrix(mat);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int iMin = Math.max(0,i-k);
                int jMin = Math.max(0,j-k);
                int iMax = Math.min(m-1,i+k);
                int jMax = Math.min(n-1,j+k);
                if(iMin == 0 && jMin == 0){
                    res[i][j] = sumMat[iMax][jMax];
                }else if(jMin == 0){
                    res[i][j] = sumMat[iMax][jMax] - sumMat[iMin-1][jMax];
                }else if(iMin == 0){
                    res[i][j] = sumMat[iMax][jMax] - sumMat[iMax][jMin-1];
                }else {
                    res[i][j] = sumMat[iMax][jMax] - sumMat[iMin-1][jMax] - sumMat[iMax][jMin-1] + sumMat[iMin-1][jMin-1];
                }
            }
        }
        return res;
    }
    public int[][] sumMatrix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        res[0][0] = mat[0][0];
        for (int i = 1; i < m; i++) {
            res[i][0] = res[i-1][0] + mat[i][0];
        }
        for (int i = 1; i < n; i++) {
            res[0][i] = res[0][i-1] + mat[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = mat[i][j] + res[i-1][j]+res[i][j-1] - res[i-1][j-1];
            }
        }
        return res;
    }
}
