package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leet
 * @description: 分割回文子字符串
 * @author: Tb
 * @create: 2021-12-20 11:31
 **/
public class offer2_86 {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public String[][] partition(String s) {
        traceBack(s,0);
        int m = ans.size();
        String[][] res = new String[m][];
        for (int i = 0; i < m; i++) {
            res[i] = new String[ans.get(i).size()];
            for (int j = 0; j < ans.get(i).size(); j++) {
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;
    }
    public void traceBack(String s,int left){
        if(left >= s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int right = left; right < s.length(); right++) {
            if (check(s,left,right)){
                path.add(s.substring(left,right+1));
                traceBack(s,right+1);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean check(String s,int left, int right){
        while (left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
