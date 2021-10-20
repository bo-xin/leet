package 字符串;

public class leet434 {
    public static void main(String[] args) {
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }
    public static int countSegments(String s) {
        if(s.length() == 0) return 0;
        String[] ss = s.split(" ");
        int cnt = 0;
        for (int i = 0; i < ss.length; i++) {
            if(ss[i].isEmpty()) continue;
            cnt++;
        }
        return cnt;
    }
}
