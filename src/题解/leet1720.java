package 题解;

public class leet1720 {
    public int[] decode(int[] encoded,int first){
        int n = encoded.length;
        int[] arr = new int[n+1];
        arr[0] = first;
        for(int i =1;i<n+1;i++){
            arr[i] = arr[i-1] ^encoded[i-1];
        }
        return arr;
    }
}
