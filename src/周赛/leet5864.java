package 周赛;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class leet5864 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{7,9},{10,7},{6,9},{10,4},{7,5},{7,10}};
        System.out.println(new leet5864().numberOfWeakCharacters(nums));
    }
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }

            }
        });
        Stack<int[]> stack = new Stack<>();
        int ans = 0;
        stack.add(properties[0]);
        int index = 1;
        int n = properties.length;
        while (index < n){
            int defense = properties[index][1];
            int attack = properties[index][0];
            while (!stack.isEmpty() && defense > stack.peek()[1] && attack > stack.peek()[0]){
                ans++;
                stack.pop();
            }
            stack.push(properties[index]);
            index++;
        }
        int temp = stack.peek()[0];
        int cura = stack.peek()[0];
        int curb = stack.peek()[1];
        int curbNext = 0;
        stack.pop();
        while (!stack.isEmpty()){
            while (!stack.isEmpty() && temp==stack.peek()[0]){
                stack.pop();
            }
            if(stack.isEmpty()) break;
            temp = stack.peek()[0];
            curbNext =stack.peek()[1];
            while (!stack.isEmpty() && temp == stack.peek()[0]){
                if(curb > stack.peek()[1]){
                    ans++;
                }
                stack.pop();
            }
            if(curb < curbNext){
                curb = curbNext;
            }
        }
        return ans;
    }
}
