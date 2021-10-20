package 周赛;

import java.util.HashMap;

public class leet5895 {
    public int minOperations(int[][] grid, int x) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                min = Math.min(min,grid[i][j]);
                max = Math.max(max,grid[i][j]);
                sum += grid[i][j];
            }
        }
        
        int target = sum/(m*n);
        System.out.println(target);
        int ans = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            int num = numOperation(grid,x,i);
            if(num != -1) {
                System.out.println(i+"  "+num);
                if(num > ans) break;
                ans = Math.min(ans,num);
            }

        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int numOperation(int[][] grid,int x, int target){
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int number = grid[i][j];
                if(Math.abs(number-target) % x == 0){
                    res += Math.abs(number-target)/x;
                }else {
                    return -1;
                }
            }
        }
        return res;
    }
}
