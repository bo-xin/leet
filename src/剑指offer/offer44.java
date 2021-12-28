package 剑指offer;

public class offer44 {
    public int findNthDigit(int n) {
        if(n == 0) return 0;
        n= n-1;
        long start = 1;
        int digit = 1;
        long count = 9*start*digit;
        while (n > count){
            n -= count;
            start *= 10;
            digit++;
            count = 9*start*digit;
        }
        long num = start + n / digit;
        System.out.println(num);
        return String.valueOf(num).charAt(n%digit);
    }
}
