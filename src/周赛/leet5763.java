package 周赛;

public class leet5763 {
    public static void main(String[] args) {
        System.out.println(new leet5763().checkZeroOnes("110100010"));
    }
    public boolean checkZeroOnes(String s) {
        int n = s.length();
        int max_0 = Integer.MIN_VALUE;
        int max_1 = Integer.MIN_VALUE;
        int cur = 0;

        for(int i = 0;i<n;i++){
            for(int j = i;j<n;){
                if(s.charAt(i)==s.charAt(j)){
                    cur++;
                    j++;
                }else{
                    i=j;
                    break;
                }
            }
            if(s.charAt(i) == '1'){
                max_1 = Math.max(cur,max_1);
            }else{
                max_0=Math.max(cur,max_0);
            }
            cur = 0;

        }
        return max_1>max_0;
    }
}
