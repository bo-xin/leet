package 模拟;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leet500 {
    static int[] array = new int[26];
    static {
        set("qwertyuiop",1);
        set("asdfghjkl",2);
        set("zxcvbnm",3);
    }
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (isTrue(word)) list.add(word);
        }
        return list.toArray(new String[list.size()]);
    }
    public static boolean isTrue(String str){
        if (str.isEmpty()){
            return true;
        }
        int avl = array[getIndex(str.charAt(0))];
        for (int i = 0; i < str.length(); i++) {
            if(array[getIndex(str.charAt(i))] != avl){
                return false;
            }
        }
        return true;
    }

    public static void set(String s,int index){
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)-'a'] = index;
        }
    }
    public static int getIndex(char c){
        if(c > 'A' && c < 'Z'){
            return c-'A';
        }else {
            return c-'a';
        }
    }
}
