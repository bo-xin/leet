package 周赛;

public class leet5867 {
    public String reversePrefix(String word, char ch) {
        int right = -1;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if(word.charAt(i) == ch){
                right = i;
                break;
            }
        }
        if(right == -1) return word;
        char[] cs = word.toCharArray();
        int left = 0;
        while (left < right){
            char temp = cs[right];
            cs[right] = cs[left];
            cs[left] = temp;
            left++;
            right--;
        }
        return new String(cs);
    }
}
