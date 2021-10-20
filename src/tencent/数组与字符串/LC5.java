package tencent.数组与字符串;

public class LC5 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new LC5().longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String pre = strs[0];
        int i = 1;
        while (i < strs.length){
            while (strs[i].indexOf(pre) != 0){
                System.out.println(strs[i].indexOf(pre));
                pre = pre.substring(0,pre.length()-1);
            }
            i++;
        }
        return pre;
    }
}
