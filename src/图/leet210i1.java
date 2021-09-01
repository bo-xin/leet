package 图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leet210i1 {
    List<List<Integer>> adjacency;
    int[] result;
    int index;
    int[] flags;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        index = numCourses--;
        result = new int[numCourses];
        flags = new int[numCourses];
        Arrays.fill(flags,0);
        adjacency = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for(int[] cp : prerequisites){
            adjacency.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(!dfs(i)) return new int[0];
        }
        return result;
    }
    public boolean dfs(int i){
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] =1;
        for(int j : adjacency.get(i)){
            if(!dfs(j)) return false;
        }
        flags[i]=-1;
        System.out.println(i);
        result[index--] = i;
        return true;
    }
}
