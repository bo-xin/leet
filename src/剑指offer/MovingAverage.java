package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leet
 * @description: 滑动窗口的平均值
 * @author: Tb
 * @create: 2021-12-06 10:06
 **/
public class MovingAverage {
    int size;
    int cnt = 0;
    double avg = 0.0;
    Queue<Integer> queue = new LinkedList<>();
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if(cnt < size){
            avg = avg*cnt+val;
            cnt++;
            queue.add(val);
            avg = avg/cnt;
        }else {
            int pre = queue.poll();
            queue.add(val);
            avg = avg*size - pre + val;
            avg = avg/size;
        }
        return avg;
    }
}
