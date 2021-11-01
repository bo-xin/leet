package 剑指offer;

import org.junit.Test;

public class offer58a2 {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        s = reverseRange(s,0,n-1);
        s = reverseRange(s,n,len-1);
        return reverseRange(s,0,len-1);
    }
    public String reverseRange(String s,int left,int right){
        char[] cs = s.toCharArray();
        while(left < right){
            char temp = cs[left];
            cs[left] = cs[right];
            cs[right] = temp;
            left++;
            right--;
        }
        String str = new String(cs);
        return  str;
    }

    @Test
    public void test(){
        System.out.println(reverseLeftWords("abcdefg",2));
    }
}
