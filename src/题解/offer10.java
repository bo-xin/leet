package 题解;

public class offer10 {
    int MOD = 1000000007;
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return (fib(n-1)+fib(n-2)) % MOD;
    }
}
