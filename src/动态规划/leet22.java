package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class leet22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        int left = 0,right = 0;
        int max = n;
        backTrace(res,sb,left,right,max);
        return res;
    }
    public void backTrace(List<String> res, StringBuffer sb, int left, int right, int max){
        if(sb.length() == max*2){
            res.add(sb.toString());
            return;
        }
        if(left < max){
            sb.append('(');
            backTrace(res,sb,left+1,right,max);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right < left){
            sb.append(')');
            backTrace(res, sb, left,right+1, max);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
