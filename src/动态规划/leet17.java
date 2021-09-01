package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class leet17 {
    private final static String[] keys = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.isEmpty()) return null;
        backTrace(digits,new StringBuffer());
        return res;
    }
    public void backTrace(String digits,StringBuffer sb){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
        int index = digits.charAt(sb.length()) - '2';
        for (char c : keys[index].toCharArray()){
            sb.append(c);
            backTrace(digits,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
