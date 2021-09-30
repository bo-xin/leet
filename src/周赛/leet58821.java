package 周赛;

public class leet58821 {
    public static void main(String[] args) {
        int[][] grid = {{2,5,4},{1,5,1}};
        System.out.println(new leet5882().gridGame(grid));
    }
    public long gridGame(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] preSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0){
                    preSum[i][j] = grid[i][j];
                }else {
                    preSum[i][j] = preSum[i][j-1] + grid[i][j];
                }
            }
        }
        int maxValue = 0;
        int[] maxNumber = new int[n];
        for (int j = 0; j < n; j++) {
            int temp =0;
            if(j==0){
                temp = preSum[0][j] + preSum[1][n-1];
            }else if(j == n-1){
                temp = preSum[0][n-1] + preSum[1][n-1] - preSum[1][n-2];
            }else {
                temp = preSum[0][j] + preSum[1][j+1] - preSum[1][j-1];
            }
            maxNumber[j] = temp;
            if(temp >  maxValue){
                maxValue = temp;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (maxNumber[j] == maxValue){
                if(j == 0){
                    ans = Math.min(ans,preSum[0][n-1]-preSum[0][0]);
                }else if (j == n-1){
                    ans  = Math.min(ans,preSum[1][n-2]);
                }else {
                    ans = Math.min(ans,Math.min(preSum[1][j-1],preSum[0][n-1]-preSum[0][j]));
                }
            }
        }
        return ans;
    }
}
