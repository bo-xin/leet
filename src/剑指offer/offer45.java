package 剑指offer;

import java.util.Arrays;
import java.util.Comparator;

public class offer45 {
    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ss, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (String s : ss) {
            sb.append(s);
        }
        return sb.toString();
    }
}
