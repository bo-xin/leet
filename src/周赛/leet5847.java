package 周赛;

import java.util.ArrayList;
import java.util.List;

public class leet5847 {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<List<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(land[i][j] == 1){
                    System.out.println("true");
                    System.out.println(i);
                    System.out.println(j);
                    temp.add(oneFarm(land,i,j));
                }
            }
        }
        int[][] ans = new int[temp.size()][4];
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < 4; j++) {
                ans[i][j] = temp.get(i).get(j);
            }
        }
        return ans;
    }
    public List<Integer> oneFarm(int[][] land,int i,int j){
        List<Integer> res =new ArrayList<>();
        int diffi = 0;
        while (i + diffi < land.length &&  land[i+diffi][j] == 1){
            diffi++;
        }
        int diffj = 0;
        while (j + diffj < land[0].length && land[i][j+diffj] == 1){
            diffj++;
        }
        res.add(i);
        res.add(j);
        res.add(i+diffi-1);
        res.add(j+diffj-1);

        for (int k = 0; k < diffi; k++) {
            for (int l = 0; l < diffj; l++) {
                land[i+k][j+l] = 0;
            }
        }
        return res;
    }
}
