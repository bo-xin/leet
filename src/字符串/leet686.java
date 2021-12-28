package 字符串;

/**
 * @program: leet
 * @description: 重复叠加字符串匹配
 * @author: Tb
 * @create: 2021-12-22 10:00
 **/
public class leet686 {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length()){
            sb.append(a);
            ans++;
        }
        sb.append(a);
        int index = strKmp(sb.toString(),b);
        if(index == -1) return -1;
        return index+b.length() > a.length()*ans ? ans+1 : ans;
    }
    public int strKmp(String ss,String pp){
        int m = pp.length();
        int n = ss.length();
        if(m==0) return 0;
        int[] next = getNext(pp);
        for (int i = 0,j=0; i < n; i++) {
            while (j > 0 && ss.charAt(i) != pp.charAt(j)) j = next[j-1];
            if(ss.charAt(i) == pp.charAt(j)) j++;
            if(j == m) return i-j+1;
        }
        return -1;

    }
    public int[] getNext(String pp){
        int[] next = new int[pp.length()];
        next[0] = 0;
        for (int i = 1,j=0; i < pp.length(); i++) {
            while (j > 0 && pp.charAt(i) != pp.charAt(j)){
                j = next[j-1];
            }
            if(pp.charAt(i) == pp.charAt(j)) j ++;
            next[i] = j;
        }
        return next;
    }
}
