package 模拟;

import java.util.HashMap;
import java.util.Map;

public class leet397 {
    /*利用map记录*/
    Map<Integer,Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        /*如果包含直接返回*/
        if(map.containsKey(n)) return map.get(n);
        /*边界条件*/
        if(n==1) return 0;
        if(n == Integer.MAX_VALUE) return 32;
        int ans = 0;
        /*奇数*/
        if((n & 1)==1){
            ans = Math.min(integerReplacement(n+1)+1,integerReplacement(n-1)+1);
        }else {
            /*偶数*/
            ans = integerReplacement(n/2)+1;
        }
        /*加入到map中*/
        map.put(n,ans);
        return ans;
    }
}
