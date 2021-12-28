package 图;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leet
 * @description: 课程表 II
 * @author: Tb
 * @create: 2021-11-30 11:25
 **/
public class leet210_1 {
    List<Integer> postOrder = new LinkedList<>();
    boolean hasCycle = false;
    boolean[] visited, onePath;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onePath = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses,prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traver(graph,i);
        }
        if(hasCycle){
            return new int[]{};
        }
        Collections.reverse(postOrder);
        int[] ans = new int[postOrder.size()];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = postOrder.get(numCourses-1-i);
        }
        return ans;
    }
    public void traver(List<Integer>[] graph,int s){
        if(onePath[s]){
            hasCycle = true;
        }
        if (visited[s] || hasCycle){
            return;
        }
        visited[s] = true;
        onePath[s] = true;
        for (Integer integer : graph[s]) {
            traver(graph,integer);
        }
        postOrder.add(s);
        onePath[s] = false;
    }

    public List<Integer>[] buildGraph(int numCourses,int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
        }
        return graph;
    }
}
