package tencent.数组与字符串;

public class LC2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int totalLength = n1+n2;
        if(totalLength % 2 == 1){
            int midIndex = totalLength/2;
            double median = findKthNumber(nums1,nums2,midIndex+1);
            return median;
        }else {
            int midIndex1 = totalLength /2, midIndex2 = totalLength/2-1;
            double median = findKthNumber(nums1,nums2,midIndex1+1)+findKthNumber(nums1,nums2,midIndex2+1);
            return median/2;
        }
    }
    public int findKthNumber(int[] nums1,int[] nums2,int k){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0, index2=0;

        while (true) {
            if(index1 == len1){
                return nums2[index2+k-1];
            }
            if(index2 == len2){
                return nums1[index1+k-1];
            }
            if(k == 1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            int half = k/2;
            int newIndex1 = Math.min(index1+half,len1)-1;
            int newIndex2 = Math.min(index2+half,len2)-1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if(pivot1 <= pivot2){
                k -=(newIndex1-index1+1);
                index1 = newIndex1+1;
            }else {
                k -= (newIndex2-index2)+1;
                index2 = newIndex2+1;
            }
        }
    }
}
