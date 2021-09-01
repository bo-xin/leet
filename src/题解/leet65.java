package 题解;
/*
有效数字（按顺序）可以分成以下几个部分：

一个 小数 或者 整数
（可选）一个 'e' 或 'E' ，后面跟着一个 整数
小数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
下述格式之一：
至少一位数字，后面跟着一个点 '.'
至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
一个点 '.' ，后面跟着至少一位数字
整数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
至少一位数字
 */
public class leet65 {
    public static void main(String[] args) {
        System.out.println(new leet65().isNumber(".0e7"));
    }
    public boolean isNumber(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int index =-1;
        for (int i = 0; i <n ; i++) {
            if(cs[i] == 'e' || cs[i] == 'E'){
                if(index == -1){
                    index = i;
                }else return false;
            }
        }
        boolean ans = true;
        if(index != -1){
            ans &= check(cs,0,index-1,false);
            ans &= check(cs,index+1,n-1,true);
        }else {
            ans &= check(cs,0,n-1,false);
        }
        return ans;
    }
    boolean check(char[] cs,int start,int end,boolean mustInteger){
        if(start > end) return false;
        if(cs[start] == '+' || cs[start] == '-') start++;
        boolean hasNum = false, hasDot = false;
        for (int i = start; i <=end ; i++) {
            if(cs[i] == '.'){
                if(mustInteger || hasDot) return false;
                hasDot = true;
            }else if(cs[i]>= '0' && cs[i]<='9'){
                hasNum =true;
            }else {
                return false;
            }
        }
        return hasNum;
    }
}
