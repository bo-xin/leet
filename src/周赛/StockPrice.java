package 周赛;

import java.util.*;

public class StockPrice {
    TreeMap<Integer,Integer> map;
    PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    PriorityQueue<Integer> min = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });
    public StockPrice() {
        map = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)){
            max.remove(map.get(timestamp));
            max.add(price);
            min.remove(map.get(timestamp));
            min.add(price);
        }else {
            max.add(price);
            min.add(price);
        }
        map.put(timestamp,price);
    }

    public int current() {
        return map.lastEntry().getValue();
    }

    public int maximum() {
        return max.peek();
    }

    public int minimum() {
        return min.peek();
    }
}
