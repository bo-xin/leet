package 剑指offer;

public class offer62 {
    public int lastRemaining(int n, int m) {
        if(n == 1)return 0;
        int x = lastRemaining(n-1,m);
        return (m+x)%n;
    }
}
