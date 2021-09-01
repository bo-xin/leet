package 题解;
/*
给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。

如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。

 */
public class leet766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int nr = matrix.length;
        int nc = matrix[0].length;

            for(int i=0;i<nr;i++){
                if(!check(matrix,matrix[i][0],i,0)){
                    return false;
                }
            }

            for(int j = 0;j<nc;j++){
                if(!check(matrix,matrix[0][j],0,j)){
                    return false;
                }
            }

        return true;
    }
    public boolean check(int[][] matrix,int val,int row ,int column){
        if(column >= matrix[0].length || row>= matrix.length){
            return true;
        }
        if(matrix[row][column] != val){
            return false;
        }
        return check(matrix,val,row+1,column+1);
    }
}
