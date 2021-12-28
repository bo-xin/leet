package 剑指offer;

public class offer2_5 {
    public int maxProduct(String[] words) {
        int m = words.length;
        int[] flag = new int[m];
        for (int i = 0; i < m; i++) {
            for (char c : words[i].toCharArray()) {
                int index = c - 'a';
                flag[i] |= (1 << index);
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if((flag[i] & flag[j]) == 0){
                    ans = Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }
}
