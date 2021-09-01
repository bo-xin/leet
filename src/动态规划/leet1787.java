package 动态规划;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leet1787 {
    private static final int MAXX = 1<<10;
    private static final int INFTY = Integer.MAX_VALUE/2;
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[MAXX];
        Arrays.fill(f,INFTY);
        f[0]=0;
        for(int i =0;i<k;++i){
            Map<Integer,Integer> map = new HashMap<>();
            int size = 0;
            for(int j=i;j<n;j+=k){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                ++size;
            }
            int t2min = Arrays.stream(f).min().getAsInt();
            int[] g = new int[MAXX];
            Arrays.fill(g,t2min);
            for(int mask = 0;mask < MAXX;++mask){
                for (Map.Entry<Integer,Integer> entry:map.entrySet()){
                    int x = entry.getKey(),countx = entry.getValue();
                    g[mask] = Math.min(g[mask],f[mask^x]-countx);
                }
            }
            for (int j = 0; j < MAXX; j++) {
                g[j] +=size;
            }
            f=g;
        }
        return f[0];
    }
}
