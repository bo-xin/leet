package 剑指offer;

import com.sun.jmx.snmp.SnmpNull;

import java.util.Arrays;

/**
 * @program: leet
 * @description: 数组中的第 k 大的数字
 * @author: Tb
 * @create: 2021-12-17 10:15
 **/
public class offer2_76 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length-1,nums.length-k);
    }
    public int quickSort(int[] nums,int l,int r,int index){
        int q = findIndex(nums,l,r);
        if(q == index){
            return nums[q];
        }else {
            return q<index ? quickSort(nums,q+1,r,index) : quickSort(nums,l,q-1,index);
        }
    }
    public int findIndex(int[] nums,int start, int end){
        int l = start, r = end;
        int temp = nums[l];
        while (l < r){
            while (l < r && nums[r] >= temp) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] < temp) l++;
            nums[r] = nums[l];
        }
        nums[l] = temp;
        return l;
    }
}
