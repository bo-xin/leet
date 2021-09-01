package 回溯;

import java.util.ArrayList;
import java.util.List;

public class leet51 {
    public static void main(String[] args) {
        System.out.println(new leet51().solveNQueens(4));
    }
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrace(board,0);
        return res;
    }
    public void backtrace(char[][] board, int row){
        if(row == board.length){
            res.add(transform(board));
            return;
        }
        int n = board.length;
        for (int j = 0; j < n; j++) {
            if(! isValid(board,row,j)) continue;
            board[row][j] = 'Q';
            backtrace(board,row+1);
            board[row][j] = '.';
        }
    }
    public List<String> transform(char[][] board){
        List<String> res = new ArrayList<>();
        int n = board.length;
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }
    public boolean isValid(char[][] board,int row,int col){
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if(board[i][col] == 'Q') return false;
        }
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n ; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
}
