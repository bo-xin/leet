package 堆栈;

import java.util.PriorityQueue;

public class leet407 {
    public static void main(String[] args) {
        //[[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
        int[][] heightMap = {{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};
        System.out.println(new leet407().trapRainWater(heightMap));
    }
    // 本体只考虑四个方向，定义四个方向
    int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        // 若数组某一边的长度小于2，不可能接雨水，直接返回0
        if(m <=2 || n <= 2) return 0;
        // 定义数组，是否已经注水，防止重复计算
        boolean[][] visit = new boolean[m][n];
        // 定义小根堆，存储当前的最小值
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        // 把四周边界值放入到小根堆中，并设置访问数组的值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || i==m-1 || j==0 || j == n-1){
                    pq.offer(new int[]{i,j,heightMap[i][j]});
                    visit[i][j] = true;
                }
            }
        }
        // 结果
        int ans = 0;
        // 遍历整个数组
        while (!pq.isEmpty()){
            // 当前注水口
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], h = cur[2];
            //四个方向遍历
            for (int[] dir : direction) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                //超出数组边界直接continue
                if(nextX <0 || nextX > m-1 || nextY < 0 || nextY >n-1) continue;
                // 访问过直接xontimue
                if(visit[nextX][nextY]) continue;
                // 如果注水口高度高于该点高低度，可以接雨水
                if(h > heightMap[nextX][nextY]) ans += h - heightMap[nextX][nextY];
                // 得到该点接雨水后的值
                heightMap[nextX][nextY] = Math.max(h,heightMap[nextX][nextY]);
                // 该点加入数组，主要为能够遍历整个数组
                pq.offer(new int[]{nextX,nextY,heightMap[nextX][nextY]});
                visit[nextX][nextY] = true;
            }
        }
        return ans;
    }
}
