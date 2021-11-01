package 数组;

public class leet240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 矩阵的长度和宽度m,n
        int m = matrix.length;
        int n = matrix[0].length;
        // 起点为右上角
        int row = 0;
        int col = n-1;
        while(row < m && col >= 0){
            //相等返回true
            if(matrix[row][col] == target) return true;
            // 大于，行++，舍弃左边的数
            if(matrix[row][col] < target) row++;
            // 小于，列--，舍弃下面的数
            else col--;
        }
        return false;
    }
}
