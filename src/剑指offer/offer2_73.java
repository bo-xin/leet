package 剑指offer;

import java.util.Arrays;

/**
 * @program: leet
 * @description: 狒狒吃香蕉
 * @author: Tb
 * @create: 2021-12-15 10:54
 **/
public class offer2_73 {
    public int minEatingSpeed(int[] piles, int h) {
        int sum = 0, max = 0;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            sum += piles[i];
            max = Math.max(max,piles[i]);
        }
        int l = sum/h, r = max;
        while (l < r){
            int mid = l + (r - l)/2;
            if(total(piles,mid) > h){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }
    public int total(int[] piles, int speed){
        int res = 0;
        for (int i = 0; i < piles.length; i++) {
            res += (piles[i]+speed-1)/speed;
        }
        return res;
    }
}
