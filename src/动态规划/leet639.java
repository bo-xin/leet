package 动态规划;

import java.util.Arrays;
import java.util.Comparator;

public class leet639 {
    public static void main(String[] args) {
        System.out.println(numDecodings("7*9*3*6*3*0*5*4*9*7*"));
    }
    public static int numDecodings(String s) {
        int MOD = 1000000000+7;
        int n = s.length();
        char[] cs = s.toCharArray();
        //当第一个字符为'0'时直接返回1
        if(cs[0] == '0') return 0;
        long[] dp = new long[n+1];
        //初始化边界条件
        dp[0] = 1;
        if(cs[0] == '*') dp[1] = 9;
        else dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // cs[i-1] == '*'
            if(cs[i-1] == '*'){
                // 先加上dp[i-1]*9
                dp[i] += dp[i-1]*9;
                //分类讨论传输cs[i-2]的情况
                if(cs[i-2] == '*'){
                    dp[i] += dp[i-2]*15;
                }else if(cs[i-2] == '1'){
                    dp[i] += dp[i-2] * 9;
                }else if(cs[i-2] == '2'){
                    dp[i] += dp[i-2] * 6;
                }
                //cs[i-1] == 0,不添加本位的次数
            }else if(cs[i-1] == '0'){
                // cs[i-2]的情况分类讨论
                if(cs[i-2] == '*'){
                    dp[i] += dp[i-2] *2;
                }else if(cs[i-2] == '1'){
                    dp[i] += dp[i-2];
                }else if(cs[i-2] == '2'){
                    dp[i] += dp[i-2];
                }
            }else {
                //讨论cs[i-1]为1-9的情况，想加上本位
                dp[i] += dp[i-1];
                // 讨论cs[i-2]和cs[i-1]的组合情况
                if(cs[i-2] == '*'){
                    if(cs[i-1] <= '6'){
                        dp[i] += dp[i-2] *2;
                    }else {
                        dp[i] += dp[i-2];
                    }
                }else if(cs[i-2] == '1'){
                    dp[i] += dp[i-2];
                }else if(cs[i-2] == '2'){
                    if(cs[i-1] <= '6'){
                        dp[i] +=dp[i-2];
                    }
                }
            }
            //取余，防止过大
            dp[i] %= MOD;
        }
        return (int)dp[n];
    }
}
