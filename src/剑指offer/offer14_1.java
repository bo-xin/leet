package 剑指offer;

public class offer14_1 {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = i-1; j >= 2; j--) {
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),dp[i-j]*j));
            }
        }
        return dp[n];
    }

    public int cuttingRope1(int n) {
        if(n <= 3) return n-1;
        int a = n/3,b=n%3;
        if(b==0) return (int)Math.pow(3,a);
        else if(b == 1) return (int) Math.pow(3,a-1)*4;
        else return (int)Math.pow(3,a)*2;
    }
}
