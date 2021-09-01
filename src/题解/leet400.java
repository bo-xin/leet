package 题解;

public class leet400 {
    public int findNthDigit(int n) {
        long num = n;
        long size = 1;
        long max =9;
        while (n>0){
            if(num - max*size>0){
                num -=max*size;
                size++;
                max *=10;
            }else{
                long count = num/size;
                long left = num%size;
                if(left == 0){
                    return (int)(((long)Math.pow(10,size-1)+count-1)%10);
                }else {
                    return (int)(((long)Math.pow(10,size-1)+count)/((long)Math.pow(10,(size-left-1)))%10);
                }
            }
        }
        return 0;
    }
}
