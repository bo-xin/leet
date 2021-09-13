package 动态规划;

public class leet42 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new leet42().trap(arr));
    }
    public int trap(int[] height) {
        int n =height.length;
        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(max < height[i]){
                index = i;
                max = height[i];
            }
        }
        int[] arr1 = new int[index+1];
        int[] arr2 = new int[n - index];
        for (int i = 0; i < index+1; i++) {
            arr1[i] = height[i];
        }
        for (int i = 0; i < n-index; i++) {
            arr2[i] = height[n-i-1];
        }
        return oneTrap(arr1) + oneTrap(arr2);
    }
    public int oneTrap(int[] height){
        int n = height.length;
        int res = 0;
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            if(maxHeight > height[i]){
                res +=(maxHeight - height[i]);
            }else{
                maxHeight = height[i];
            }
        }
        return res;
    }
}
