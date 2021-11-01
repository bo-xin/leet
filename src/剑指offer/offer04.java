package 剑指offer;

public class offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col =n-1;
        while (row <m && col>=0){
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}
