package 数组;

import java.util.Arrays;

public class leet1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        Arrays.sort(bookings,(a,b)->a[0]-b[0]);
        for (int[] booking : bookings){
            if(booking[1] <= n){
                for (int i = booking[0]; i <= booking[1]; i++) {
                    ans[i-1] += booking[2];
                }
            }else {
                for (int i = booking[0]; i <= n; i++) {
                    ans[i-1] += booking[2];
                }
            }
        }
        return ans;
    }
}
