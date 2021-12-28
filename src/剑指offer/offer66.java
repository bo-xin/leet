package 剑指offer;

public class offer66 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        if(n == 0) return new int[0];
        int[] b = new int[n];
        b[0] = 1 ;
        int tmp = 1;
        for (int i = 1; i < n; i++) {
            b[i] = b[i-1]*a[i-1];
        }
        for (int i = n-2; i >= 0; i--) {
            tmp *= a[i+1];
            b[i] *= tmp;
        }
        return b;
    }
}
