package 基础算法;

import org.junit.Test;

/**
 * @program: leet
 * @description: 排序算法
 * @author: Tb
 * @create: 2021-12-17 11:27
 **/
public class Sort {

    @Test
    public void test(){
        int[] arr = {1,5,8,9,7,4,13,4,6};
        InsertSort(arr);
        for (int i : arr) {
            System.out.print(i+"  ");
        }
    }

    public void InsertSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            /*有序数组最后一位*/
            int end = i;
            int temp = arr[end+1];
            while (end >= 0 &&arr[end] > temp){
                arr[end+1] = arr[end];
                end--;
            }
            arr[end+1] = temp;
        }
    }

    public void ShellSort(int[] arr){
        int n = arr.length;

    }
}
