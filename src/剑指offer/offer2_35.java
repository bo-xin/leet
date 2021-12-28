package 剑指offer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leet
 * @description: 最小时间差
 * @author: Tb
 * @create: 2021-12-02 10:14
 **/
public class offer2_35 {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> listMinute = new LinkedList<>();
        for (String point : timePoints) {
            System.out.println(point);
            int minute = Integer.valueOf(point.substring(1,3))*60+Integer.valueOf(point.substring(4,6));
            System.out.println(minute);
            listMinute.add(minute);
        }
        Collections.sort(listMinute);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < listMinute.size(); i++) {
            ans = Math.min(ans,listMinute.get(i) - listMinute.get(i-1));
        }
        int diff = 24*60-listMinute.get(listMinute.size()-1)+listMinute.get(0);
        ans = Math.min(diff,ans);
        return ans;
    }
}
