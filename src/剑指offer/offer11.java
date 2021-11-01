package 剑指offer;

public class offer11 {
    public int minArray(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            min = Math.min(min,numbers[i]);
        }
        return min;
    }
}
