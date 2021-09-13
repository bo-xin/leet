package 动态规划;

public class leet1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int mx = values[0] + 0;
        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans,mx+values[i]  -i );
            mx = Math.max(mx,values[i]+i);
        }
        return ans;
    }
}
