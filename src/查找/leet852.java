package 查找;
/*
符合下列属性的数组 arr 称为 山脉数组 ：
arr.length >= 3
存在 i（0 < i < arr.length - 1）使得：
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。

 */
public class leet852 {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        while (l<r){
            int mid = l+(r-l)/2;
            if(arr[mid] < arr[mid+1]){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return l;
    }
}
