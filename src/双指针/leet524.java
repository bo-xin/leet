package 双指针;

import java.util.List;

/*
给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。

如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 */
public class leet524 {
    public String findLongestWord(String s, List<String> dictionary) {
        //返回值
        String longestStr = "";
        //遍历字典中的字符串
        for(String str:dictionary){
            int l1 = longestStr.length(),l2 = str.length();
            //判断是否长度最长且字典序更小，不满足条件，continue
            if(l1 > l2 || (l1 == l2 && longestStr.compareTo(str)<0)){
                continue;
            }
            //判断你是否是s的一个序列
            if(isSubStr(s,str)){
                longestStr = str;
            }
        }
        return longestStr;

    }
    //判断是否是s的子序列
    public boolean isSubStr(String s,String sub){
        //i和j分别是s和sub字符串的指针
        int i =0, j=0;
        //判断ij指针是否越界
        while (i<s.length() && j<sub.length()){
            //若字符串sub和s的某个相同，怎j++
            if(s.charAt(i) == sub.charAt(j)){
                j++;
            }
            //指针i每次都需要自增
            i++;
        }
        //当j的值等于长度时，说明是子序列。返回true
        return j == sub.length();
    }
}
