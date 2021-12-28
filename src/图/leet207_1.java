package 图;

import 剑指offer.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leet
 * @description: 课程表
 * @author: Tb
 * @create: 2021-11-30 10:59
 **/
public class leet207_1 {
    boolean[] onePath;
    boolean[] visited;
    boolean hasCycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int form = prerequisite[0];
            int to = prerequisite[1];
            graph[form].add(to);
        }
        onePath = new boolean[numCourses];
        visited = new boolean[numCourses];
        hasCycle = false;
        for (int i = 0; i < numCourses; i++) {
            traver(graph,i);
        }
        return !hasCycle;
    }
    public void traver(List<Integer>[] graph,int s){
        if(onePath[s]){
            hasCycle = true;
        }
        if(visited[s] || hasCycle) return;
        visited[s] = true;
        onePath[s] = true;
        for (Integer integer : graph[s]) {
            traver(graph,integer);
        }
        onePath[s] = false;
    }
}
