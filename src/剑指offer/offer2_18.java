package 剑指offer;

/**
 * @program: leet
 * @description: 有效的回文
 * @author: Tb
 * @create: 2021-11-28 11:43
 **/
public class offer2_18 {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if((c>='a' && c <='z') || (c>='A' && c<='Z') || (c>='0' && c <= '9')){
                if (c>='A' && c<= 'Z'){
                    c = Character.toLowerCase(c);
                }
                sb.append(c);
            }
        }
        int l = 0,r = sb.length()-1;
        while (l < r){
            if(sb.charAt(l) != sb.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
