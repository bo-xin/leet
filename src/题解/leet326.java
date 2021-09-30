package 题解;

public class leet326 {
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0){
            n /= 3;
        }
        return n == 1;
    }
}
