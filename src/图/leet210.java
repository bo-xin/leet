package 图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet210 {
    //bfs
    private int index = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res =new int[numCourses];

        int[] inDegrees = new int[numCourses];
        List<List<Integer>> adjacency = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] cp :prerequisites){
            inDegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegrees[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int pre = queue.poll();
            res[index++] = pre;
            for(int cur : adjacency.get(pre)){
                if(--inDegrees[cur] == 0) queue.add(cur);
            }
        }
        if(index != numCourses) return new int[0];
        return res;
    }
}
