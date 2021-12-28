package 剑指offer;

/**
 * @program: leet
 * @description: 求平方根
 * @author: Tb
 * @create: 2021-12-15 10:38
 **/
public class offer2_72 {
    public int mySqrt(int x) {
        int l = 0, r = x/2;
        while (l <= r){
            int mid = l + (r-l)/2;
            long pow = (long)mid * mid;
            if (pow == x) return mid;
            else if(pow > x) r = mid-1;
            else l = mid + 1;
        }
        return l-1;
    }
}
