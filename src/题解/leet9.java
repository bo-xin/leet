package 题解;

public class leet9 {
    public boolean isPalindrome(int x){
        if(x<0 || x>10 && x%10 == 0){
            return false;
        }
        int res = 0;
        while (res <x){
            res = res*10 + x%10;
            x = x/10;
        }
        return res == x || res == x/10;
    }
}
