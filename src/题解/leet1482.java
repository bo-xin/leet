package 题解;

public class leet1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length) return -1;
        int low = 1,high = 1;
        for(int i=0;i<bloomDay.length;i++){
            high = Math.max(high,bloomDay[i]);
        }
        while (low<high){
            int mid=(low+high)/2;
            if(check(bloomDay,mid,m,k)){
                high=mid;
            }else {
                low = mid+1;
            }
        }
        return low;
    }
    public boolean check(int[]bloomDay,int day,int m,int k){
        int blooms = 0;
        int flowers = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i] <= day){
                flowers++;
                if(flowers == k){
                    blooms++;
                    flowers=0;
                }
            }else{
                flowers=0;
            }
        }
        return blooms>=m;
    }
}
