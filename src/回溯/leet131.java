package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet131 {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],true);
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
            }
        }
        backtrace(s,dp,n,0);
        return ans;
    }
    public void backtrace(String s, boolean[][] dp,int n, int i){
        if(i == n){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < n; j++) {
            if(dp[i][j]){
                path.add(s.substring(i,j+1));
                backtrace(s, dp, n,j+1);
                path.remove(path.size()-1);
            }
        }
    }

}
