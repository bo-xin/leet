package 查找;

import java.util.Arrays;

/**
 * @program: leet
 * @description: 供暖期
 * @author: Tb
 * @create: 2021-12-20 09:53
 **/
public class leet475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0, r = (int)1e9;
        while (l < r){
            int mid = (l + r)/2;
            if(check(houses,heaters,mid)) r = mid;
            else l = mid+1;
            System.out.println(l+ "   "+r);
        }
        return r;
    }
    public boolean check(int[] house,int[] heaters, int x){
        int n = house.length;
        int m = heaters.length;
        for (int i = 0,j = 0; i < n; i++) {
            while (j<m && house[i] > heaters[j]+x) j++;
            if(j < m && heaters[j] - x <= house[i] && house[i] <= heaters[j]+x) continue;
            return false;
        }
        return true;
    }
}
