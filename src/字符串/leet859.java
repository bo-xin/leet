package 字符串;

public class leet859 {
    public boolean buddyStrings(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        if(m != n) return false;
        int[] cntS = new int[26];
        int[] cntG = new int[26];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int a = s.charAt(i) - 'a';
            int b = goal.charAt(i) - 'a';
            cntG[b]++;
            cntS[a]++;
            if(a != b) sum++;
        }
        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            if(cntS[i] != cntG[i]) return false;
            if(cntG[i] > 1) ok = true;
        }
        return sum == 2 || (sum == 0 && ok);
    }
}
