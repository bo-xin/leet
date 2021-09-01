package 题解;

public class leet696 {
    public int countBinarySubstrings(String s){
        int ptr = 0;
        int n = s.length();
        int last = 0;
        int ans =0;
        while(ptr < n){
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr<n && c == s.charAt(ptr)){
                count++;
                ptr++;
            }
            ans += Math.min(last,count);
            last = count;
        }
        return ans;
    }
}
