package 图;

import java.util.*;

public class leet207 {
    //bfs判断是否有环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        //adjacency邻近的
        List<List<Integer>> adjacency = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for(int[] cp :prerequisites){
            inDegrees[cp[1]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(inDegrees[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()){
            int pre = queue.poll();
            System.out.println(pre);
            numCourses--;
            for(int cur : adjacency.get(pre)){

                if(--inDegrees[cur] == 0) queue.add(cur);
            }
        }
        return numCourses == 0;
    }
    //dfs判断是否有环
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new LinkedList<>();
        for (int i = 0; i <numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
        Arrays.fill(flags,0);
        for(int[] cp : prerequisites){
            adjacency.get(cp[0]).add(cp[1]);
        }
        for(int i =0;i<numCourses;i++){
            if(!dfs(adjacency,flags,i)) return false;
        }
        return true;
    }
    //判断是否是无环图(无环图，返回true)
    public boolean dfs(List<List<Integer>> adjacency, int[] flags,int i){
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;
        for(int j:adjacency.get(i)){
            if(!dfs(adjacency,flags,j)) return false;
        }
        flags[i] = -1;
        return true;
    }
}
