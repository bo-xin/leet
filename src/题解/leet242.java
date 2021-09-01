package 题解;

public class leet242 {
    public boolean isAnagram(String s,String t){
        int[] cnts = new int[26];
        for(char c:s.toCharArray()){
            cnts[c-'a']++;
        }
        for(char c:t.toCharArray()){
            cnts[c-'a']--;
        }
        for(int n:cnts){
            if(n !=0){
                return false;
            }
        }
        return true;
    }
}
