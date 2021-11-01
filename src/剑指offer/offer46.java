package 剑指offer;

public class offer46 {
    public static void main(String[] args) {
        System.out.println(new offer46().translateNum(12258));
    }
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int n =str.length();
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = str.charAt(i)-'0';
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if(number[i-2] == 0){
                dp[i] += dp[i-1];
            }else {
                if(number[i-1]+number[i-2]*10 < 26) dp[i] += dp[i-2];
                dp[i] += dp[i-1];
            }
        }
        return dp[n];
    }
}
