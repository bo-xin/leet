package 字符串;

/**
 * @program: leet
 * @description: 赎金信
 * @author: Tb
 * @create: 2021-12-06 09:56
 **/
public class leet383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magCnt = new int[26];
        int[] ranCnt = new int[26];
        for (char c : ransomNote.toCharArray()) {
            ranCnt[c-'a']++;
        }
        for (char c : magazine.toCharArray()) {
            magCnt[c-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(ranCnt[i] == 0)continue;
            if(ranCnt[i] <= magCnt[i]) continue;
            return false;
        }
        return true;
    }
}
