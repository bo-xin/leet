package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leet
 * @description: 矩阵中的距离
 * @author: Tb
 * @create: 2021-12-27 20:54
 **/
public class offer2_107 {
    int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int step = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                int r = temp[0], c = temp[1];
                for (int[] dir : direction) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if(nc < 0 || nc >= n || nr < 0 || nr >= m || visited[nr][nc]) continue;
                    dist[nr][nc] = step +1;
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }
            }
            step++;
        }
        return dist;
    }
}
