package 回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leet301 {
    // set存储和去重
    Set<String> set = new HashSet<>();
    // 字符长度，最大可能长度，最大长度
    int n,max,len;
    String str;
    public List<String> removeInvalidParentheses(String s) {
        str = s;
        n = s.length();
        // 遍历得到字符串中左右括号个数
        int l = 0,r = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') l++;
            else if(s.charAt(i) == ')') r++;
        }
        // 理论上最长长度
        max = Math.min(l,r);
        // 暴力DFS
        dfs(0,"",0);
        return new ArrayList<>(set);
    }
    public void dfs(int index,String cur,int score){
        // 边界条件返回，说明当前情况下已经不合法
        if(score < 0 || score > max) return;
        // 遍历完字符串
        if(index == n){
            // 满足更新条件
            if(score == 0 && cur.length()>=len){
                // 大于最大长度，set清空，并更新最大长度
                if(cur.length() > len) {
                    set.clear();
                    len = cur.length();
                }
                // 添加当前情况
                set.add(cur);
            }
            return;
        }
        // 当前字符
        char c = str.charAt(index);
        if(c == '('){
            // 添加当前（
            dfs(index+1,cur+String.valueOf(c),score+1);
            // 不添加当前（
            dfs(index+1,cur,score);
        }else if(c == ')'){
            //添加当前）
            dfs(index+1,cur+String.valueOf(c),score-1);
            // 不添加当前）
            dfs(index+1,cur,score);
        }else {
            // 添加字母
            dfs(index+1,cur+String.valueOf(c),score);
        }
    }
}
