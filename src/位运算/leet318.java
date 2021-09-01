package 位运算;

public class leet318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] var = new int[n];
        for (int i = 0; i < n; i++) {
            for(char c : words[i].toCharArray()){
                var[i] |= 1<<(c-'a');
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if((var[i]&var[j]) == 0){
                    ret = Math.max(ret,words[i].length()*words[j].length());
                }
            }
        }
        return ret;
    }
}
