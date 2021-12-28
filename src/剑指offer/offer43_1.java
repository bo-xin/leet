package 剑指offer;

public class offer43_1 {
    public int countDigitOne(int n) {
        int res = 0;
        long mulk = 1;
        while (n >= mulk){
            res += (n % (mulk*10)*mulk)+Math.min(Math.max(n%(mulk*10)-mulk,0),mulk);
            mulk *= 10;
        }
        return res;
    }
}
