package 字符串;

import java.util.HashSet;
import java.util.Set;

public class leet720 {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words){
            set.add(word);
        }
        String ans = "";
        for (String word : words){
            if(word.length() > ans.length() ||
                    word.length()== ans.length() && word.compareTo(ans)<0){
                boolean good = true;
                for (int i = 1; i < word.length(); i++) {
                    if(!set.contains(word.substring(0,i))){
                        good = false;
                        break;
                    }
                }
                if(good) ans = word;
            }
        }
        return ans;
    }
}
