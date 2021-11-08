package 查找;

public class leet367 {
    public static void main(String[] args) {
        System.out.println(new leet367().isPerfectSquare1(2147483647));
    }
    public boolean isPerfectSquare(int num) {
        /*初始化x*/
        long x = 1,square = 1;
        /*边界条件，大于num跳出循环*/
        while (square <= num){
            /*如果相等直接返回true*/
            if(square == num) return true;
            /*自增x，更新square*/
            ++x;
            square = x*x;
        }
        /*返回false*/
        return false;
    }
    public boolean isPerfectSquare1(int num) {
        /*定义左右边界*/
        long left =0,right = num;
        while (left < right){
            /*找到中间值*/
            long mid = (left+right+1) >> 1;
            /*判断和num的关系，若小于则left右移*/
            if(mid * mid <= num) left = mid;
            /*若大于则右指针左移*/
            else right = mid-1;
        }
        /*返回是否相等即可*/
        return left*left == num;
    }
}
