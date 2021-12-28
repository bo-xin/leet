package 查找;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leet
 * @description: 边界着色
 * @author: Tb
 * @create: 2021-12-07 09:28
 **/
public class leet1034 {
    List<int[]> borders = new ArrayList<>();
    int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};
    public int[][] colorBorder(int[][] grid,int row, int col, int color){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[row][col] = true;
        dfs(grid,visited,row,col,grid[row][col]);
        for (int[] border : borders) {
            int x = border[0], y = border[1];
            grid[x][y] = color;
        }
        return grid;
    }
    public void dfs(int[][] grid,boolean[][] visited, int x,int y,int originalColor){
        int m = grid.length;
        int n = grid[0].length;
        boolean isBorder = false;
        for (int[] direction : directions) {
            int nx = direction[0]+x, ny = direction[1]+y;
            if((nx >= 0 && nx < m && ny >=0 && ny < n && grid[nx][ny] == originalColor)){
                isBorder = true;
            }else if(!visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(grid,visited,nx,ny,originalColor);
            }
        }
        if(isBorder){
            borders.add(new int[]{x,y});
        }
    }
}
