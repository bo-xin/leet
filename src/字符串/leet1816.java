package 字符串;

/**
 * @program: leet
 * @description: 截断句子
 * @author: Tb
 * @create: 2021-12-06 10:02
 **/
public class leet1816 {
    public String truncateSentence(String s, int k) {
        String[] ss = s.split(" ");
        String ans = "";
        for (int i = 0; i < k-1; i++) {
            ans += ss[i]+" ";
        }
        ans += ss[k-1];
        return ans;
    }
}
