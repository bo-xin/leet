package 数组;

public class leet162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        return search(nums,0,n-1);
    }
    public int search(int[] nums,int l,int r){
        //当左右指针相等时候返回
        if(l==r) return l;
        //中间指针
        int mid = (l+r)/2;
        //比较中间nums[mid]和nums[mid+1]
        if(nums[mid] > nums[mid+1]){
            //在左边寻找
            return search(nums,l,mid);
        }else {
            //在右边寻找
            return search(nums,mid+1,r);
        }
    }

    public int findPeakElement1(int[] nums) {
        //数组长度
        int n = nums.length;
        //左右指针
        int l = 0, r = n - 1;
        while (l < r) {
            //中间指针
            int mid = l + r >> 1;
            //二分查找方式
            if (nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        //返回索引
        return r;
    }

    public int findPeakElement2(int[] nums) {
        //遍历数组,注意右边界
        for(int i =0;i<nums.length-1;i++){
            //寻找到第一个峰值
            if(nums[i]>nums[i+1]){
                return i;
            }
        }
        //此时数组单调递增，又边界为峰值
        return nums.length-1;
    }
}
