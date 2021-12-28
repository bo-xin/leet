package 图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leet
 * @description: 所有可能的路径
 * @author: Tb
 * @create: 2021-11-29 21:47
 **/
public class leet797 {

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traver(graph,0,path);
        return res;
    }
    public void traver(int[][] graph,int s,LinkedList<Integer> path){
        path.addLast(s);
        int n = graph.length;
        if(s == n-1){
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        for (int v : graph[s]) {
            traver(graph, v, path);
        }
        path.removeLast();
    }

}
