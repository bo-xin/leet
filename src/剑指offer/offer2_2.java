package 剑指offer;

public class offer2_2 {
    public static void main(String[] args) {
        System.out.println(new offer2_2().addBinary("11","10"));
    }
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        int len = Math.max(m,n);
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for (int i = 0; i < len; i++) {
            carry += i < m ? a.charAt(m-1-i)-'0' : 0;
            carry += i < n ? b.charAt(n-1-i)-'0' : 0;
            sb.append(carry%2);
            carry /= 2;
        }
        if(carry > 0){
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }
}
