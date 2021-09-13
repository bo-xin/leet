package 动态规划;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leet139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        Set<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
