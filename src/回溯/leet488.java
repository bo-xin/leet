package 回溯;

public class leet488 {
    public static void main(String[] args) {
        System.out.println(new leet488().findMinStep("WRRBBW","RB"));
    }

    /*声明返回ans，颜色数组，记录hand中数量数组*/
    int ans = Integer.MAX_VALUE;
    char[] colors = {'R','Y','B','G','W'};
    int[] numbers = new int[26];
    public int findMinStep(String board, String hand) {
        /*分别记录board和hand长度*/
        int m = board.length();
        int n = hand.length();
        if(m == 0) return 0;
        if(n == 0) return -1;
        /*记录hand中颜色的数量*/
        for (int i = 0; i < n; i++) {
            numbers[hand.charAt(i)-'A']++;
        }
        dfs(new StringBuffer(board),0);
        /*如果ans没有更新，则说明不能清空，返回-1*/
        return ans==Integer.MAX_VALUE ? -1:ans;
    }
    public void dfs(StringBuffer board,int step){
        /*优化，当step大于当前最好步数直接返回*/
        if(step >= ans){
            return;
        }
        /*递归终止条件*/
        if(board.length() == 0){
            /*更新ans并返回*/
            ans = Math.min(ans,step);
            return;
        }
        /*遍历board中所有位置*/
        for (int i = 0; i < board.length(); i++) {
            /*得到当前的字符*/
            char c = board.charAt(i);
            int j = i+1;
            /*记录board中最长的相同颜色的位置*/
            while (j<board.length() && board.charAt(j)== c){
                j++;
            }
            /*如果只有一个颜色的球，同时该颜色球数量大于等于2个，则可以添加*/
            if(j==i+1 && numbers[c-'A'] >= 2){
                /*申请临时变量存储，回溯时候board不用变化*/
                StringBuffer tmp = new StringBuffer(board);
                /*对tmp添加两个相同颜色球*/
                tmp.insert(i,c+""+c);
                /*对应颜色球数量减少*/
                numbers[c-'A']-=2;
                /*递归遍历，对tmp进行消除*/
                dfs(remove(tmp),step+2);
                /*回溯*/
                numbers[c-'A']+=2;
            }else if(j==i+2){ //两个颜色相同的球挨在一起
                /*判断hand中求得数量*/
                if(numbers[c-'A'] >= 1){
                    /*声明临时变量*/
                    StringBuffer tmp = new StringBuffer(board);
                    /*添加球，然后修改球数量，递归，回溯*/
                    tmp.insert(i,c);
                    numbers[c-'A']--;
                    dfs(remove(tmp),step+1);
                    numbers[c-'A']++;
                }
                /*在相同颜色中间插入不通颜色球*/
                for (char color : colors) {
                    if(c == color) continue;
                    /*该颜色球大于一个，则添加后回溯处理*/
                    if(numbers[color-'A']>=1){
                        StringBuffer tmp = new StringBuffer(board);
                        tmp.insert(i+1,color);
                        numbers[color-'A']--;
                        dfs(remove(tmp),step+1);
                        numbers[color-'A']++;
                    }
                }
            }
        }
    }
    /*移除board中连续的球数量*/
    public StringBuffer remove(StringBuffer sb){
        /*记录是否进行移除*/
        boolean flag = true;
        while (flag){
            /*设置flag为false*/
            flag = false;
            /*对数组进行遍历，并移除连续的球*/
            for (int i = 0; i < sb.length(); i++) {
                int j = i+1;
                /*寻找连续相同球的位置*/
                while (j < sb.length() && sb.charAt(j) == sb.charAt(i)){
                    j++;
                }
                /*如果长度>=3，删除并使flag=true*/
                if(j-i>=3){
                    sb.delete(i,j);
                    flag = true;
                }
            }
        }
        return sb;
    }
}
