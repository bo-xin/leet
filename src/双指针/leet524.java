package 双指针;

import java.util.List;

/*
给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。

如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 */
public class leet524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String longestStr = "";
        for(String str:dictionary){
            int l1 = longestStr.length(),l2 = str.length();
            if(l1 > l2 || (l1 == l2 && longestStr.compareTo(str)<0)){
                continue;
            }

            if(isSubStr(s,str)){

                longestStr = str;
            }
        }
        return longestStr;

    }
    public boolean isSubStr(String s,String sub){
        int i =0, j=0;
        while (i<s.length() && j<sub.length()){
            if(s.charAt(i) == sub.charAt(j)){
                j++;
            }
            i++;
        }
        return j == sub.length();
    }
}
