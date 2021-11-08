package 剑指offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianFinder {

    int len;
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
        len = 0;
    }

    public void addNum(int num) {
        list.add(num);
        len++;
    }

    public double findMedian() {
        Collections.sort(list);
        if(len % 2 == 1){
            return (double)list.get(len/2+1);
        }else {
            return ((double)list.get(len/2)+(double)list.get(len/2+1))/2;
        }
    }
}
