package 模拟;

public class leet318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        /*记录返回值*/
        int ans = 0;
        /*声明数组记录字母所在位置*/
        int[] mask = new int[n];
        /*遍历words*/
        for (int i = 0; i < n; i++) {
            /*对word中每一个字符进行处理*/
            for (char c : words[i].toCharArray()) {
                /*记录每一个字母所在位置，因为只记录位置所以使用或运算*/
                mask[i] |= 1 << c-'a';
            }
        }
        /*遍历所有word对*/
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                /*如果没有相同的字母，更新ans*/
                if((mask[i] & mask[j]) == 0){
                    ans = Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
        /*返回*/
        return ans;
    }
}
