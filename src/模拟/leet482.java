package 模拟;

public class leet482 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuffer sb = new StringBuffer();
        for (int i = s.length()-1, cnt = 0; i >=0 ; i--) {
            if(s.charAt(i) == '-') continue;
            if(cnt == k && (cnt = 0)>=0){
                sb.append('-');
            }
            sb.append(s.charAt(i));
            cnt++;
        }
        String str = sb.reverse().toString();
        System.out.println(str);
        return str.toUpperCase();
    }
}
