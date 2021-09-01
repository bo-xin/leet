package 题解;

import java.util.Arrays;
import java.util.HashSet;

public class leet128 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        int res = new leet128().longestConsecutive(nums);
        System.out.println(res);
    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longestStreak = 0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int cur = 1;
                int curNum = num;
                while (set.contains(curNum+1)){
                    cur+=1;
                    curNum+=1;
                }
                longestStreak = Math.max(longestStreak,cur);
            }

        }
        return longestStreak;
    }
}
