package 双指针;

import java.util.Arrays;
import java.util.HashSet;

/*
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */
public class leet345 {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        char[]result = new char[s.length()];
        while (i<=j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!vowels.contains(ci)){
                result[i++] = ci;
            }else if(!vowels.contains(cj)){
                result[j--] = cj;
            }else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

}
