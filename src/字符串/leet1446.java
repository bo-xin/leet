package 字符串;

/**
 * @program: leet
 * @description: 连续字符
 * @author: Tb
 * @create: 2021-12-01 09:28
 **/
public class leet1446 {
    public int maxPower(String s) {
        int n = s.length();
        /*长度为0，直接返回*/
        if(n == 0) return 0;
        /*记录返回值*/
        int ans = 1;
        /*记录当前长度*/
        int curLen = 1;
        for (int i = 1; i < n; i++) {
            /*如果字符相同，curLen++，并更新ans*/
            if(s.charAt(i-1) == s.charAt(i)){
                curLen++;
                ans =Math.max(ans,curLen);
                /*不等重置长度*/
            }else {
                curLen = 1;
            }
        }
        return ans;
    }
}
