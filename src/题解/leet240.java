package 题解;
/*
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
 */
public class leet240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix[0].length==0 || matrix.length == 0)return false;
        int nr = matrix.length;
        int nc = matrix[0].length;
        int row = 0,col = nc-1;
        while(row < nr && col>=0){
            System.out.println(matrix[row][col]);
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] > target) col--;
            else row++;
         }
        return false;
    }
}
