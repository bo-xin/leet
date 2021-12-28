package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leet
 * @description: 最近请求次数
 * @author: Tb
 * @create: 2021-12-06 10:15
 **/
public class RecentCounter {
    List<Integer> list;
    int left, right;
    public RecentCounter() {
        list = new ArrayList<>();
        left = 0;
        right = -1;
    }

    public int ping(int t) {
        list.add(t);
        right++;
        int cnt = 0;
        while (left <right && list.get(left) < t-3000){
            left++;
        }
        cnt = right-left+1;
        return cnt;
    }
}
