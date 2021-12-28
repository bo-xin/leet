package 剑指offer;

public class offer2_1 {
    public int divide(int a, int b) {
        long x = a,y = b;
        int flag = 1;
        if(x < 0){
            x = -x;
            flag = -flag;
        }
        if(y < 0){
            y = -y;
            flag = -flag;
        }
        long res = 0;
        long weight;
        while (x >= y){
            weight = 1;
            long tmp = y;
            while (tmp + tmp <= x){
                weight += weight;
                tmp += tmp;
            }
            x -= tmp;
            res += weight;
        }
        if(flag == -1) res = -res;
        return  res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res;
    }
}
