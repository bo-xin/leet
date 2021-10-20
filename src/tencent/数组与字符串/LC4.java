package tencent.数组与字符串;

public class LC4 {
    public static void main(String[] args) {
        System.out.println(new LC4().myAtoi("  -42"));
    }
    int MAX = Integer.MAX_VALUE;
    int MIN = Integer.MIN_VALUE;
    public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty()) return 0;
        int num = 0;
        int neg = 1;
        int index = 0;
        if(s.charAt(0) == '-' || s.charAt(0)=='+'){
            neg = s.charAt(index++) == '+' ?1:-1;
        }
        for (;index<s.length();index++){
            int digit = s.charAt(index) - '0';
            if(digit <0 || digit >9){
                break;
            }
            if(num > MAX / 10 || (num == MAX/10 && digit>MAX%10)){
                return neg == 1 ? MAX : MIN;
            }else {
                num = num *10 + digit;
            }
        }
        return neg == 1? num:-num;
    }

}
