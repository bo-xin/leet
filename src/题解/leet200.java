package 题解;
/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

 */
public class leet200 {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0){
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for(int i = 0;i<nr;i++){
            for(int j = 0;j<nc;j++){
                if(grid[i][j] == '1'){
                    num_islands++;
                    dfs(grid,i,j);
                }
            }
        }
        return num_islands;
    }
    public void dfs(char[][] grid,int r,int c){
        int nr = grid.length;
        int nc = grid[0].length;
        if(r<0 || c <0 || r>=nr || c >=nc || grid[r][c]=='0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
}
