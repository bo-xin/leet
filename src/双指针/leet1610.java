package 双指针;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: leet
 * @description: 可见点的最大数目
 * @author: Tb
 * @create: 2021-12-16 09:36
 **/
public class leet1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        /*人的位置相关坐标*/
        int x = location.get(0), y = location.get(1);
        /*存储极角的信息*/
        List<Double> list = new ArrayList<>();
        /*使用PI，使得int类型转换为角度表示*/
        double pi = Math.PI, temp = angle*pi/180;
        /*记录点和人重合的数量*/
        int count = 0;
        /*遍历所有点*/
        for (List<Integer> point : points) {
            /*点相关的位置信息*/
            int a = point.get(0), b = point.get(1);
            /*如果重合直接计数加1*/
            if(x == a && y == b && ++count > 0) continue;
            /*添加极角信息*/
            list.add(Math.atan2(b-y,a-x));
        }
        /*对极角进行排序*/
        Collections.sort(list);
        int n = list.size();
        /*跨越二三象限统一处理*/
        for (int i = 0; i < n; i++) {
            list.add(list.get(i)+2*pi);
        }
        /*记录当前角度中的最大数值*/
        int max = 0;
        /*使用滑动窗口思想遍历所有点*/
        for (int j = 0,i = 0; j < 2*n; j++) {
            while (i < j && list.get(j) - list.get(i) > temp) i++;
            max = Math.max(max,j-i+1);
        }
        /*返回结果*/
        return count+max;
    }
}
