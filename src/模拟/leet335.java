package 模拟;

public class leet335 {
    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        /*长度小于4不会相交*/
        if(n < 4) return false;
        for (int i = 3; i < n; i++) {
            /*分别对应三种不同情况，成立条件根据解题图中给出*/
            if(distance[i] >= distance[i-2] && distance[i-1] <= distance[i-3]) return true;
            if(i >= 4 && distance[i-1] == distance[i-3] && distance[i]+distance[i-4] >= distance[i-2]) return true;
            if(i >= 5 && distance[i-3]>= distance[i-1] && distance[i]+distance[i-4]>=distance[i-2] && distance[i-2]>=distance[i-4]
            && distance[i-1] + distance[i-5] >= distance[i-3]) return true;
        }
        //返回
        return false;
    }
}
