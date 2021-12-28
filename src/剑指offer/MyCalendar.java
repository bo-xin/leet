package 剑指offer;

import org.omg.CORBA.INTERNAL;

import java.util.Map;
import java.util.TreeMap;

/**
 * @program: leet
 * @description: 日程表
 * @author: Tb
 * @create: 2021-12-10 10:48
 **/
public class MyCalendar {
    TreeMap<Integer,Integer> timeMap;
    public MyCalendar() {
        timeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer,Integer> floorPeriod = timeMap.floorEntry(start);
        Map.Entry<Integer,Integer> ceilPeriod = timeMap.ceilingEntry(start);
        int lastEnd = Integer.MIN_VALUE;
        int nextStart = Integer.MAX_VALUE;
        if(floorPeriod != null){
            lastEnd = floorPeriod.getValue();
        }
        if(ceilPeriod != null){
            nextStart = ceilPeriod.getKey();
        }
        if(lastEnd <= start && end < nextStart){
            timeMap.put(start,end);
            return true;
        }
        return false;
    }
}
