package 剑指offer;

public class offer13 {
    int ans = 0;
    int _m , _n;
    public int movingCount(int m, int n, int k) {
        _m = m;
        _n = n;
        boolean[][] isVisited = new boolean[m][n];
        dfs(0,0,k,isVisited);
        return ans;
    }
    public void dfs(int x,int y,int k,boolean[][] isVisited){
        if(x < 0 || x >= _m || y < 0 || y>= _n || isSum(x,y,k)){
            return;
        }
        if(isVisited[x][y]) return;
        isVisited[x][y] = true;
        ans++;
        dfs(x+1,y,k,isVisited);
        dfs(x,y+1,k,isVisited);
    }
    public boolean isSum(int x,int y,int k){
        int sum = 0;
        while (x != 0){
            sum += x %10;
            x /= 10;
        }
        while (y != 0){
            sum += y %10;
            y /= 10;
        }
        return sum>k;
    }
}
