package 剑指offer;

public class offer14_2 {
    int MOD = 1000000007;
    public int cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;
        long res = 1;
        while (n > 4){
            res = res * 3 % MOD;
            n -= 3;
        }
        return (int)(res*n%MOD);
    }
}
