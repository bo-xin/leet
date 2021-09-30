package 周赛;

public class leet5882 {
    public static void main(String[] args) {
        int[][] grid = {{20,3,20,17,2,12,15,17,4,15},{20,10,13,14,15,5,2,3,14,3}};
        System.out.println(new leet5882().gridGame(grid));
    }
    public long gridGame(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] preSum = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0){
                    preSum[i][j] = (long)grid[i][j];
                }else {
                    preSum[i][j] = (long)(preSum[i][j-1] + (long)grid[i][j]);
                }
            }
        }
        long ans = Long.MAX_VALUE;
        System.out.println(Long.MAX_VALUE);
        for (int j = 0; j < n; j++) {
            if(j==0){
                ans = Math.min(ans,preSum[0][n-1]-preSum[0][0]);
            }else if(j == n-1){
                ans = Math.min(ans,preSum[1][n-2]);
            }else {
                ans = Math.min(ans,Math.max(preSum[1][j-1],preSum[0][n-1]-preSum[0][j]));
            }
        }
        return ans;
    }
}
