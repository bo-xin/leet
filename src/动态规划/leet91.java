package 动态规划;

public class leet91 {
    public static void main(String[] args) {
        System.out.println(new leet91().numDecodings("2101"));
    }
    public int numDecodings(String s) {
        int n = s.length();
        s = " "+s;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int a = s.charAt(i) - '0';
            int b = (s.charAt(i-1) - '0')*10 + (s.charAt(i)-'0');
            if(a>=1 && a<= 9) dp[i] = dp[i-1];
            if(b>=10 && b<= 26) dp[i] += dp[i-2];
        }
        return dp[n];
    }
}
