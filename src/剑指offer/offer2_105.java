package 剑指offer;

/**
 * @program: leet
 * @description: 岛屿最大面积
 * @author: Tb
 * @create: 2021-12-27 19:31
 **/
public class offer2_105 {
    int sum = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int  res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                   dfs(grid,i,j);
                   res = Math.max(res,sum);
                   sum = 0;
                }
            }
        }
        return res;
    }
    public void dfs(int[][] grid,int x,int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1){
            return;
        }
        grid[x][y] = 2;
        sum++;
        dfs(grid,x+1,y);
        dfs(grid,x,y+1);
        dfs(grid,x-1,y);
        dfs(grid,x,y-1);
    }
}
