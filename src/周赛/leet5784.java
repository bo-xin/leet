package 周赛;
/*
给你一个字符串数组 words（下标 从 0 开始 计数）。

在一步操作中，需先选出两个 不同 下标 i 和 j，其中 words[i] 是一个非空字符串，接着将 words[i] 中的 任一 字符移动到 words[j] 中的 任一 位置上。

如果执行任意步操作可以使 words 中的每个字符串都相等，返回 true ；否则，返回 false 。
 */
public class leet5784 {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        int[] count = new int[100];
        for(String str : words){
            for(char c :str.toCharArray()){
                count[c-'a'] +=1;
            }
        }
        for(int num :count){
            if(num % n != 0){
                return false;
            }
        }
        return true;
    }
}
