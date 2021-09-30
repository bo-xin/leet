package 周赛;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet5883 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{' ','#','a'},{' ','#','c'},{' ','#','a'}};
        System.out.println(new leet5883().placeWordInCrossword(board,"ca"));
    }
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i),i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
            }
        }        
        return false;
    }
}
