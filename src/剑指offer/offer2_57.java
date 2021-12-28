package 剑指offer;

import java.util.TreeSet;

/**
 * @program: leet
 * @description: 值和下标之差都在给定的范围内
 * @author: Tb
 * @create: 2021-12-10 10:37
 **/
public class offer2_57 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long)nums[i]-(long)t);
            if(ceiling != null && ceiling <= (long)nums[i]+(long)t){
                return true;
            }
            set.add((long)nums[i]);
            if(i >= k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
