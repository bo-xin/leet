package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leet
 * @description: 生成匹配的括号
 * @author: Tb
 * @create: 2021-12-20 10:29
 **/
public class offer2_85 {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuffer sb = new StringBuffer();
        traceBack(n,sb,0,0);
        return ans;
    }
    public void traceBack(int n,StringBuffer sb,int l,int r){
        if(sb.length() == 2*n){
            ans.add(sb.toString());
            return;
        }
        if(l < n){
            sb.append('(');
            traceBack(n,sb,l+1,r);
            sb.deleteCharAt(sb.length()-1);
        }
        if(r < l){
            sb.append(')');
            traceBack(n,sb,l,r+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
