package 回溯;

public class leet306 {
    String str;
    int n;
    public boolean isAdditiveNumber(String num) {
        str = num;
        n = num.length();
        return dfs(0,0,0,0);
    }
    public boolean dfs(int index, long sumTwo, long previous, int count){
        if(index == n){
            return count >= 3;
        }
        long value = 0;
        for (int i = index; i < n; i++) {
            if (i > index && str.charAt(index) == '0') break;
            value = value*10 + str.charAt(i) - '0';
            if(count >= 2){
                if(value < sumTwo){
                    continue;
                }
                if(value > sumTwo){
                    break;
                }
            }
            if(dfs(i+1,previous+value,value,count+1)){
                return true;
            }
        }
        return false;
    }
}
