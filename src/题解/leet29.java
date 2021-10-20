package 题解;

public class leet29 {
    int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
    int LIMIT = -1073741824;
    public int divide(int a, int b){
        if(a == MIN && b == -1) return MAX;
        boolean flag = false;
        if((a>0 && b<0) || (a<0 && b>0)) flag = true;
        if(a > 0) a =- a;
        if(b > 0) b = -b;
        int ans = 0;
        while (a <= b){
            int c = b, d = -1;
            while (c >= LIMIT && d>= LIMIT && c >= a-c){
                c += c; d+=d;
            }
            a -= c;
            ans += d;
        }
        return flag ? ans : -ans;
    }
}
