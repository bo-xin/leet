package 剑指offer;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leet
 * @description: 所有子集
 * @author: Tb
 * @create: 2021-12-18 13:39
 **/
public class offer2_79 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if(n == 0) return ans;
        for (int i = 0; i < Math.pow(2,n); i++) {
            List<Integer> subAns = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if((i & (1 << j)) > 0){
                    subAns.add(nums[j]);
                }
            }
            ans.add(subAns);
        }
        return ans;
    }


}
