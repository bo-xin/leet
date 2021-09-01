package 周赛;
/*
如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。

给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。

注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。

子字符串 是一个字符串中连续的字符序列
 */
public class leet5754 {
    public static void main(String[] args) {
        System.out.println(new leet5754().countGoodSubstrings("aababcabc"));
    }
    public int countGoodSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i+2 <n ; i++) {
            if(s.charAt(i) != s.charAt(i+1) &&
            s.charAt(i) != s.charAt(i+2)
            && s.charAt(i+1) != s.charAt(i+2)){
                res++;
            }
        }
        return res;
    }
}
