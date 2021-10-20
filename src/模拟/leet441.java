package 模拟;

public class leet441 {
    public static void main(String[] args) {
        System.out.println(new leet441().arrangeCoins(15));
    }
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left < right){
            int mid = (right - left+1) /2 + left;
            if((long)mid*(mid+1) <= (long)2*n){
                left = mid;
            }else {
                right = mid-1;
            }
        }
        return left;
    }
}
