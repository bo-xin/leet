package 剑指offer;

public class offer15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            n &=n-1;
            count++;
        }
        return count;
    }

}
