package 题解;

public class leet1486 {
    public int xorOperation(int n,int start){
        int res = 0;
        for(int i =0;i<n;i++){
            int cur = start+2*i;
            res^=cur;
        }
        return res;
    }
}
