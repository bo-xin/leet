package 剑指offer;

/**
 * @program: leet
 * @description: 山峰数组的顶部
 * @author: Tb
 * @create: 2021-12-14 10:02
 **/
public class offer2_69 {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        if(n < 3) return 0;
        int l = 1, r = n-1;
        while (l < r){
            int mid = (l+r+1) >> 1;
            if(arr[mid - 1] < arr[mid]) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}
