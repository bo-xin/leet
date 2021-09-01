package 图;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。
给你一个二维数组 graph ，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。
形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性：
不存在自环（graph[u] 不包含 u）。
不存在平行边（graph[u] 不包含重复值）。
如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
 */
public class leet785 {
    //深度优先搜索
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        valid = true;
        color = new int[n];
        Arrays.fill(color,UNCOLORED);
        for(int i = 0;i<n && valid;i++){
            if(color[i] == UNCOLORED){
                dfs(i,RED,graph);
            }
        }
        return valid;
    }
    public void dfs(int node,int c,int[][] graph){
        color[node] = c;
        int cNei = c == RED?GREEN:RED;
        for (int neighbor : graph[node]){
            if(color[neighbor] == UNCOLORED){
                 dfs(neighbor,cNei,graph);
                 if(!valid){
                     return;
                 }
            }else if(color[neighbor] != cNei){
                valid = false;
                return;
            }
        }
    }
}

class leet7851{
    //广度优先搜索
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color,UNCOLORED);
        for (int i = 0; i < n; i++) {
            if(color[i] == UNCOLORED){
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = RED;
                while (!queue.isEmpty()){
                    int node = queue.poll();
                    int cNei = color[node] == RED?GREEN:RED;
                    for(int neighbor : graph[node]){
                        if(color[neighbor] == UNCOLORED){
                            queue.offer(neighbor);
                            color[neighbor] = cNei;
                        }else if(color[neighbor] != cNei){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
