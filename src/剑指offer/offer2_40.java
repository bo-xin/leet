package 剑指offer;

import java.util.Stack;

/**
 * @program: leet
 * @description: 矩阵中最大的矩形
 * @author: Tb
 * @create: 2021-12-06 20:19
 **/
public class offer2_40 {
    public int maximalRectangle(String[] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length();
        int[][] matrix1 = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix1[i][j] = matrix[i].charAt(j)-'0';
            }
        }
        int[][] matrix2 = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix1[i][j] == 0){
                    matrix2[i][j] = 0;
                    continue;
                }
                if(i == 0){
                    matrix2[i][j] = matrix1[i][j];
                }else {
                    matrix2[i][j] = matrix1[i][j] + matrix2[i-1][j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int temp = maxOneRow(matrix2[i]);
            ans = Math.max(temp,ans);
        }
        return ans;
    }
    public int maxOneRow(int[] heights){
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                ans = Math.max(ans,width*height);
            }
            stack.add(i);
        }
        while (stack.peek() != -1){
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() -1;
            ans = Math.max(ans,height*width);
        }
        return ans;
    }
}
