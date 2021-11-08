package 剑指offer;

public class offer58_1 {
    public String reverseWords(String s) {
        String[] ss = s.split("\\s+");
        int n = ss.length;
        StringBuffer sb = new StringBuffer();
        for (int i = n-1; i >= 0; i--) {
            sb.append(ss[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
