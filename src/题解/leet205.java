package 题解;

public class leet205 {
    public boolean isIsomorphic(String s, String t) {
        int[] indexOfS = new int[256];
        int[] indexOfT = new int[256];
        for(int i = 0;i<s.length();i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(indexOfS[cs] != indexOfT[ct]){
                return false;
            }
            indexOfS[cs] = i+1;
            indexOfT[ct] = i+1;
        }
        return true;
    }
}
