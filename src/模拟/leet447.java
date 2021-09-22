package 模拟;

import java.util.HashMap;
import java.util.Map;

public class leet447 {
    public int numberOfBoomerangs(int[][] points) {
        //记录总数
        int ans = 0;
        //遍历节点
        for (int[] p0 : points){
            //记录以距离和数量
            Map<Integer,Integer> map = new HashMap<>();
            //遍历节点，记录每个点到p0的距离
            for (int[] p1 : points){
                //计算距离
                int key = (p0[0]-p1[0])*(p0[0]-p1[0]) + (p0[1] - p1[1])*(p0[1] - p1[1]);
                map.put(key,map.getOrDefault(key,0)+1);
            }
            //遍历map，计算出每个距离下可以选择的数量
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                int value = entry.getValue();
                //计算相同距离下的数量，并计入总数
                ans += value*(value-1);
            }
        }
        //返回
        return ans;
    }
}
