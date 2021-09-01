package 位运算;
/*
不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 */
public class leet371 {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum((a^b),(a & b) << 1);
    }
}
