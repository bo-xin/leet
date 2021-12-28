package 模拟;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet391 {
    public boolean isRectangleCover(int[][] rectangles) {
        int n = rectangles.length;
        int[][] rs = new int[2*n][4];
        int idx = 0;
        for (int[] re : rectangles) {
            rs[idx++] = new int[]{re[0],re[1],re[3],1};
            rs[idx++] = new int[]{re[2],re[1],re[3],-1};
        }
        Arrays.sort(rs,(a,b)->{
            if (a[0] != b[0])return a[0]-b[0];
            return a[1] - b[1];
        });
        n *= 2;
        List<int[]> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        for (int l = 0; l < n; ) {
            int r = l;
            l1.clear();
            l2.clear();
            while (r < n && rs[r][0] == rs[l][0]) r++;
            for (int i = l; i < r; i++) {
                int[] cur = new int[]{rs[i][1],rs[i][2]};
                List<int[]> list = rs[i][3]==1 ? l1:l2;
                if(list.isEmpty()){
                    list.add(cur);
                }else {
                    int[] prev = list.get(list.size()-1);
                    if(cur[0] < prev[1]) return false;
                    else if(cur[0] == prev[1]) prev[1] = cur[1];
                    else list.add(cur);
                }
            }
            if(l > 0 && r< n){
                if(l1.size() != l2.size()) return false;
                for (int i = 0; i < l1.size(); i++) {
                    if(l1.get(i)[0] == l2.get(i)[0] && l1.get(i)[1] == l2.get(i)[1]) continue;
                    return false;
                }
            }else {
                if(l1.size() + l2.size() != 1) return false;
            }
            l = r;
        }
        return true;
    }
}
