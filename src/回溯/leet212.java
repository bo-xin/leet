package 回溯;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leet212 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        String[] list = new String[]{"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"};
        System.out.println(new leet212().findWords(board,list));
    }

    //定义返回值
    List<String> res = new ArrayList<>();
    //定义相邻方向
    int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    //定义board的长高
    int m,n;
    //定义一个sb，用来存当前遍历路劲
    StringBuffer sb = new StringBuffer();
    char[][] _board;
    //记录需要遍历的String
    Set<String> set = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        _board = board;
        m = board.length;
        n = board[0].length;
        //记录words
        for (String word : words) set.add(word);
        // 遍历数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 遍历以当前位置开头的所有能够组成的words
                boolean[][] visited = new boolean[m][n];
                //把当前位置加入sb
                visited[i][j] = true;
                sb.append(board[i][j]);
                isHasWord(i,j,visited);
                // 当前位置清除
                sb.deleteCharAt(sb.length()-1);
                visited[i][j] = false;
            }
        }
        return res;
    }
    public  void isHasWord(int i,int j,boolean[][] visited){
        //字符长度不会大于10，大于10 直接返回
       if(sb.length() > 10) return;
       // set中包含当前遍历到的string
       if(set.contains(sb.toString())){
            //加入返回值
           res.add(sb.toString());
           //从set移除
           set.remove(sb.toString());
           return;
       }
       //遍历不同方向
       for(int[] dir : direction){
           int nextI = dir[0] + i,nextJ = dir[1] + j;
           //判断边界条件
           if(nextI <0 || nextI>= m || nextJ<0 || nextJ >=n) continue;
           //判断是否被访问
           if(visited[nextI][nextJ]) continue;
           // 回溯模块核心
           visited[nextI][nextJ] = true;
           sb.append(_board[nextI][nextJ]);
           isHasWord(nextI,nextJ,visited);
           sb.deleteCharAt(sb.length()-1);
           visited[nextI][nextJ] = false;
       }
    }
}
