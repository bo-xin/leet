package 动态规划;

import java.util.Arrays;

public class leet1894 {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int num : chalk){
            sum += num;
        }
        k %= sum;
        int res = -1;
        for (int i = 0; i < chalk.length; i++) {
            if(chalk[i] > k){
                res = i;
                break;
            }
            k -= chalk[i];
        }
        return res;
    }
}
