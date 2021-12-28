package 剑指offer;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @program: leet
 * @description: 数组相对排序
 * @author: Tb
 * @create: 2021-12-16 10:33
 **/
public class offer2_75 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int i = 0; i < arr1.length; i++) {
            upper = Math.max(upper,arr1[i]);
        }
        int[] frequency = new int[upper+1];
        for (int i = 0; i < arr1.length; i++) {
            frequency[arr1[i]]++;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < frequency[arr2[i]]; j++) {
                ans[index++] = arr2[i];
            }
            frequency[arr2[i]] = 0;
        }
        for (int i = 0; i < upper+1; i++) {
            for (int j = 0; j < frequency[i]; j++) {
                ans[index++] = i;
            }
        }
        return ans;
    }
}
