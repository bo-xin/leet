package 剑指offer;

import org.junit.Test;

public class offer12 {
    @Test
    public void test(){
        char[][] board = {{'a','a'}};
        System.out.println(new offer12().exist(board, "aaa"));
    }


    int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    char[][] _board;
    int m,n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        _board = board;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                StringBuffer path = new StringBuffer();
                boolean[][] isVisited = new boolean[m][n];
                path.append(board[i][j]);
                isVisited[i][j] = true;
                if(dfs(word,path,isVisited,i,j)) return true;
            }
        }
        return false;
    }
    public boolean dfs(String word, StringBuffer path, boolean[][] isVisited,int x,int y){
        if(path.length() == word.length()){
            if(word.equals(path.toString())){
                return true;
            }
            return false;
        }
        for (int[] dir : direction) {
            int curX = x + dir[0];
            int curY = y + dir[1];
            if(curX < 0 || curX >= m || curY < 0 || curY>= n) continue;
            if(isVisited[curX][curY]) continue;
            isVisited[curX][curY] = true;
            path.append(_board[curX][curY]);
            if (dfs(word,path,isVisited,curX,curY)) return true;
            path.deleteCharAt(path.length()-1);
            isVisited[curX][curY] = false;
        }
        return false;
    }
}
