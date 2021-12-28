package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leet
 * @description: 复原 IP
 * @author: Tb
 * @create: 2021-12-20 11:04
 **/
public class offer2_87 {
    List<String> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if(n < 4 || n >12){
            return ans;
        }
        traceBack(s,0,n);
        return ans;
    }
    public void traceBack(String s,int idx,int n){
        if(path.size() == 4){
            if(idx == n){
                String cur = String.join(".",path);
                ans.add(cur);
            }
            return;
        }
        if(idx == n){
            return;
        }
        if(s.charAt(idx) == '0'){
            path.add("0");
            traceBack(s,idx+1,n);
            path.remove(path.size()-1);
        }else {
            for (int i = idx; i < n; i++) {
                int cur_num = Integer.parseInt(s.substring(idx,i+1));
                if(cur_num >= 0 && cur_num <= 255){
                    path.add(s.substring(idx,i+1));
                    traceBack(s,i+1,n);
                    path.remove(path.size()-1);
                }else {
                    break;
                }
            }
        }
    }
}
