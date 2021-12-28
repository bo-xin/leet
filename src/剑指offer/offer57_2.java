package 剑指offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class offer57_2 {
    public static void main(String[] args) {
        System.out.println(new offer57_2().findContinuousSequence(9));
    }
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for (int l = 1,r=2; l < r;) {
            int sum = (l+r)*(r-l+1)/2;
            if(sum == target){
                int[] tmp = new int[r - l+1];
                for (int i = l; i <= r; i++) {
                    tmp[i-l] = i;
                }
                list.add(tmp);
                r++;
            }else if(sum < target){
                r++;
            }else {
                l++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
