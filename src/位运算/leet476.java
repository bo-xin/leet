package 位运算;
/*
给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 */
public class leet476 {
    public int findComplement(int num) {
        int mask = 1<<30;
        while ((mask & num) == 0) mask >>=1;
        mask = (mask<<1)-1;
        return mask ^ num;
    }
}
