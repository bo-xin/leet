package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class offer29 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new offer29().spiralOrder(matrix));
    }
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length ==0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        if(m==0 || n==0) return new int[0];
        List<Integer> list = new ArrayList<>();
        int left = 0,right = n-1,top = 0,bottom = m-1;
        while (left<= right && top <= bottom){
            for (int i = left; i <=right; i++) {
                list.add(matrix[top][i]);
            }
            for (int i = top+1; i < bottom; i++) {
                list.add(matrix[i][right]);
            }
            for (int i = right; i >left ; i--) {
                list.add(matrix[bottom][i]);
            }
            for (int i = bottom; i > top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        int[] ans = new int[m*n];
        for (int i = 0; i < m*n; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
