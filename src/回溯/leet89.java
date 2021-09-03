package 回溯;

import java.util.ArrayList;
import java.util.List;

public class leet89 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> grayCode(int n) {
        backtrace(n,new StringBuffer(),new int[]{0,1});
        return res;
    }
    public void backtrace(int n, StringBuffer sb, int[] nums){
        //判断条件，是否返回
        if(sb.length() == n){
            // 二进制转换为十进制
            res.add(Integer.valueOf(sb.toString(),2));
            return;
        }
        // 回溯第一个状态
        sb.append(nums[0]);
        //注意数组
        backtrace(n,sb,new int[]{0,1});
        sb.deleteCharAt(sb.length()-1);
        // 回溯第二个状态
        sb.append(nums[1]);
        //注意数组
        backtrace(n,sb,new int[]{1,0});
        sb.deleteCharAt(sb.length()-1);
    }
}
