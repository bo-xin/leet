package 题解;

public class leet647 {
    private int ans = 0;
    public int countSubstrings(String s){
        for(int i =0;i<s.length();i++){
            count(s,i,i);
            count(s,i,i+1);
        }
        return ans;
    }
    public void count(String s,int l,int r){
        while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            ans++;
        }
    }
}
