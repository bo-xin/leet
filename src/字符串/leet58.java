package 字符串;

public class leet58 {
    public int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        int n = ss.length;
        return ss[n-1].length();
    }
}
