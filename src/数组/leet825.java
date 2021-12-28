package 数组;

import java.util.Arrays;

/**
 * @program: leet
 * @description: 适龄的朋友
 * @author: Tb
 * @create: 2021-12-27 17:27
 **/
public class leet825 {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0;
        int n = ages.length;
        for (int k = 0,i = 0,j = 0; k < n; k++) {
            while (i < k && !check(ages[i],ages[k])) i++;
            if(j < k) j = k;
            while (j < n && check(ages[j],ages[k])) j++;
            if(j > i) ans += j-i-1;
        }
        return ans;
    }
    public boolean check(int x,int y){
        if (y <= 0.5 * x + 7) return false;
        if (y > x) return false;
        if (y > 100 && x < 100) return false;
        return true;
    }
}
