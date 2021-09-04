package 动态规划;

public class leet473 {
    public static void main(String[] args) {
        System.out.println(new leet473().makesquare(new int[]{1,1,2,2,2}));
    }
    int[] bucket = new int[4];
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks == null || matchsticks.length == 0) return false;
        int sum = 0;
        for (int num : matchsticks){
            sum += num;
        }
        if(sum % 4 != 0) return false;
        int edge = sum / 4;
        return backtrace(matchsticks, edge,matchsticks.length,0);
    }
    public boolean backtrace(int[] matchsticks,int edge, int n, int index){
        if(index == n){
            return bucket[0] == bucket[1] && bucket[1] == bucket[2]
                    && bucket[2] == bucket[3] ;
        }
        int element = matchsticks[index];
        for (int i = 0; i < 4; i++) {
            if(bucket[i] + element <= edge){
                bucket[i] += element;
                if(backtrace(matchsticks,edge,n,index+1)){
                    return true;
                }
                bucket[i] -= element;
            }
        }
        return false;
    }
}
