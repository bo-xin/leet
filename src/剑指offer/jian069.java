package 剑指offer;

public class jian069 {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        if(n < 3) return -1;
        int ans = -1;
        for (int i = 1; i < n-1; i++) {
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                ans = i;
                break;
            }
        }
        return ans;
    }
}
