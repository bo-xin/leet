package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offer38 {
    int len;
    List<String> res = new ArrayList<>();
    public String[] permutation(String s) {
        len = s.length();
        boolean[] visited = new boolean[len];
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        dfs(cs, new StringBuffer(),visited);
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
    public void dfs(char[] cs,StringBuffer path,boolean[] visited){
        if(path.length() == len){
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < len; i++) {
            if(visited[i]) continue;
            if(i > 0 && cs[i] == cs[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            path.append(cs[i]);
            dfs(cs,path,visited);
            path.deleteCharAt(path.length()-1);
            visited[i] = false;
        }
    }
}
