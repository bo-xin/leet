package 模拟;

import java.util.Scanner;

public class leet66 {
    public int[] plusOne(int[] digits) {
        /*原数组长度*/
        int n = digits.length;
        /*遍历找到进位的位置*/
        for (int i = n-1; i >= 0; i--) {
            if(digits[i] != 9){
                /*进位位置加1*/
                digits[i]++;
                /*进位后面的位置全部置0*/
                for (int j = i+1; j < n; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        /*中间没有返回说明整数为999...999
        * 新建数组长度为n+1*/
        int[] ans = new int[n+1];
        /*置第一位为1*/
        ans[0] = 1;
        return ans;
    }
}
