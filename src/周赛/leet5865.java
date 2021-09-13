package 周赛;

public class leet5865 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,0};
        System.out.println(new leet5865().firstDayBeenInAllRooms(nums));
    }
    int MOD = 1000000007;
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = (2*dp[i-1] - dp[nextVisit[i-1]]+2) % MOD;
        }
        return dp[n-1];
    }
}
