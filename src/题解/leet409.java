package 题解;

public class leet409 {
    public int longestPalindrome(String s) {
        int[] cnts = new int[128];
        for(char c : s.toCharArray()){
            cnts[c]++;
        }
        int ans =0;
        for(int n:cnts){
            ans +=(n/2)*2;
        }
        if(ans < s.length()){
            ans ++;
        }
        return ans;
    }
}
