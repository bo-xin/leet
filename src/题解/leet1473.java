package 题解;

import org.omg.CORBA.MARSHAL;

public class leet1473 {
    public static void main(String[] args) {
        int[] houses = new int[]{0,0,0,1};
        int[][] cost = new int[][]{{1,5},{4,1},{1,3},{4,4}};
        int m = 4;
        int n =2;
        int target = 4;
        System.out.println(new leet1473().minCost(houses,cost,m,n,target));
    }
    int INF = 0x3f3f3f3f;
    public int minCost(int[] houses,int[][] cost,int m,int n,int target){
        int[][][] f = new int[m+1][n+1][target+1];
        for(int i = 0;i<=m;i++){
            for(int j =0;j<=n;j++){
                f[i][j][0]=INF;
            }
        }
        for(int i = 1;i<=m;i++){
            int color = houses[i-1];
            for(int j=1;j<=n;j++){
                for(int k=1;k<=target;k++){
                    if(k>i){
                        f[i][j][k] = INF;
                        continue;
                    }
                    if(color!=0){
                        if(j == color){
                            int temp = INF;
                            for(int p = 1;p<=n;p++){
                                if(p!=j){
                                    temp = Math.min(temp,f[i-1][p][k-1]);
                                }

                            }
                            f[i][j][k] = Math.min(temp,f[i-1][j][k]);
                        }else {
                            f[i][j][k] = INF;
                        }
                    }else {
                        int u = cost[i-1][j-1];
                        int temp = INF;
                        for(int p =1;p<=n;p++){
                            if(p!=j){
                                temp=Math.min(temp,f[i-1][p][k-1]);
                            }
                        }
                        f[i][j][k] = Math.min(temp,f[i-1][j][k])+u;
                    }
                    System.out.println(f[m][j][target]);
                }
            }
        }
        int ans = INF;
        for(int i =1;i<=n;i++){
            ans = Math.min(ans,f[m][i][target]);
        }
        return ans == INF?-1:ans;
    }
}
