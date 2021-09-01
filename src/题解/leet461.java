package 题解;
/*
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离
 */
public class leet461 {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x>1 || y>1){
            int xa = x % 2;
            int ya = y % 2;
            if(ya != xa){
                count++;
            }
            x /=2;
            y/=2;
        }
        if(x != y){
            count++;
        }
        return count;
    }
}
