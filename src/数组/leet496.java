package 数组;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class leet496 {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(new leet496().nextGreaterElement(nums1,nums2));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[len1];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = len2-1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num > stack.peek()){
                stack.pop();
            }
            map.put(num,stack.isEmpty()? -1 : stack.peek());
            stack.push(num);
        }
        for (int i = 0; i < len1; i++) {
            if(map.containsKey(nums1[i])){
                ans[i] = map.get(nums1[i]);
            }
        }
        return ans;
    }
}
