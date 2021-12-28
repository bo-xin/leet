package 剑指offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

/**
 * @program: leet
 * @description: 剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器
 * @author: Tb
 * @create: 2021-12-01 09:37
 **/
public class RandomizedSet {
    Set<Integer> set;
    LinkedList<Integer> list;
    int size;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
        list = new LinkedList<>();
        size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.contains(val)){
            return false;
        }else {
            set.add(val);
            list.addLast(val);
            size++;
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            list.remove((Integer)val);
            size--;
            return true;
        }else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        System.out.println(size);
        Random r = new Random();
        int index = r.nextInt(size);
        return list.get(index);
    }
}
