package 数组;

/**
 * @program: leet
 * @description: 保持城市天际线
 * @author: Tb
 * @create: 2021-12-13 10:17
 **/
public class leet807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        /*分别记录水平和垂直方向的最大高度*/
        int[] rowSky = new int[m];
        int[] columnSky = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /*因为求每一行和每一列的高度的最大值
                * 所以只需要根据i和j更新得到响应的最大高度*/
                rowSky[i] = Math.max(rowSky[i],grid[i][j]);
                columnSky[j] = Math.max(columnSky[j],grid[i][j]);
            }
        }
        /*设置返回值*/
        int ans = 0;
        /*遍历整个grid*/
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /*得到水平和垂直方向的最低高度*/
                int sky = Math.min(rowSky[i],columnSky[j]);
                /*在原有基础上增加*/
                ans += sky - grid[i][j];
            }
        }
        return ans;
    }
}
