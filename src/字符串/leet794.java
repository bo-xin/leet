package 字符串;

/**
 * @program: leet
 * @description: 有效的井字游戏
 * @author: Tb
 * @create: 2021-12-09 10:08
 **/
public class leet794 {
    public boolean validTicTacToe(String[] board) {
        int x = 0, o = 0;
        char[][] cs = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i].charAt(j) == 'X') x++;
                if(board[i].charAt(j) == 'O') o++;
                cs[i][j] = board[i].charAt(j);
            }
        }
        boolean a = check(cs,'X'), b = check(cs,'O');
        if(o > x || x-o > 1) return false;
        if(a && x <= o) return false;
        if(b && x != o) return false;
        if(a && b) return false;
        return true;
    }
    public boolean check(char[][] cs,char c){
        boolean a = true, b = true;
        for (int i = 0; i < 3; i++) {
            if(cs[i][0] == c && cs[i][1] == c && cs[i][2] == c) return true;
            if(cs[0][i] == c && cs[1][i] == c && cs[2][i] == c) return true;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j) a &= cs[i][j] == c;
                if(i+j == 2) b &= cs[i][j] == c;
            }
        }
        return a || b;
    }
}
