package 模拟;

import org.junit.Test;

/**
 * @program: leet
 * @description: N 位数字
 * @author: Tb
 * @create: 2021-11-30 09:14
 **/
public class leet400 {
    @Test
    public void test1(){
        System.out.println(findNthDigit(2500));
    }
    public int findNthDigit(int n) {
        int len = 1;
        while (len * 9 * Math.pow(10,len-1) < n){
            n -= len * 9 * Math.pow(10,len-1);
            len++;
        }
        long s = (long)Math.pow(10,len-1);
        long x = n/len -1+s;
        n -= (x-s+1)*len;
        return  n == 0 ?(int)(x % 10) : (int) ((x + 1) / (int) (Math.pow(10, len - n)) % 10);
    }
}
