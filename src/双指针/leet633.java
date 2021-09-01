package 双指针;
/*
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 */
public class leet633 {
    public boolean judgeSquareSum(int c) {
        int a = 0, b =(int) Math.sqrt(c);
        while (a<=b){
            int powSum = a*a+b*b;
            if(powSum == c){
                return true;
            }else if(powSum > c){
                b--;
            }else {
                a++;
            }
        }
        return false;
    }
}
