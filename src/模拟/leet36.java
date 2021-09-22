package 模拟;

public class leet36 {
    public boolean isValidSudoku(char[][] board) {
        //初始化每行，每列和每一个区域的boolean数组
        boolean[][] row = new boolean[10][10];
        boolean[][] col = new boolean[10][10];
        boolean[][] area = new boolean[10][10];
        //遍历数组
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c == '.') continue;
                // 得到当前数字
                int u = c - '0';
                // 根据坐标得区域
                int index = i / 3 * 3+ j / 3;
                // 判断以前是否已经存在，存在则返回false
                if(row[i][u] || col[j][u] || area[index][u]) return false;
                //
                row[i][u] = col[j][u] = area[index][u] = true;
            }
        }
        return true;
    }
}
