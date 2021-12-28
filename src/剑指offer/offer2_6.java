package 剑指offer;

public class offer2_6 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while (l < r){
            if(numbers[l] + numbers[r] == target){
                return new int[]{l,r};
            }else if(numbers[l]+numbers[r] < target){
                l++;
            }else {
                r--;
            }
        }
        return new int[2];
    }
}
