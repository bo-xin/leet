package 数组;

public class leet299 {
    public static void main(String[] args) {
        System.out.println(new leet299().getHint("1123","0111"));
    }
    public String getHint(String secret, String guess) {
        int n = secret.length();
        /*分别记录A和B的数量*/
        int countA=0 , countB=0;
        /*记录两个字符串中出现的次数，在不同位置*/
        int[] numsA = new int[10];
        int[] numsB = new int[10];
        for (int i = 0; i < n; i++) {
            /*相同位置相等countA++*/
            if(secret.charAt(i) == guess.charAt(i)){
                countA++;
            }else {
                /*不同位置分别记录*/
                numsA[secret.charAt(i)-'0']++;
                numsB[guess.charAt(i)-'0']++;
            }
        }
        /*对两个数组分别进行遍历*/
        for (int i = 0; i < 10; i++) {
            countB += Math.min(numsA[i],numsB[i]);
        }
        /*返回字符串*/
        return countA+"A"+countB+"B";
    }
}
