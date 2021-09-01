package 题解;
/*
给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 */
public class leet378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n-1][n-1];
        while(lo < hi){
           int mid = lo+((hi-lo)>>1);
           if(check(matrix,k,mid)){
               hi = mid;
           }else{
               lo = mid +1;
           }
        }
        return lo;
    }
    public boolean check(int[][] matrix,int k,int mid){
        int num = 0;
        int n = matrix.length;
        int i = n-1;
        int j = 0;
        while (j<n && i>=0){
            if(matrix[i][j] <= mid){
                num+=i+1;
                j++;
            }else {
                i--;
            }
        }
        return num >=k;
    }
}
