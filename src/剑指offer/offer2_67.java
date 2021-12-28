package 剑指offer;

/**
 * @program: leet
 * @description: 最大异或
 * @author: Tb
 * @create: 2021-12-13 11:17
 **/
public class offer2_67 {
    Node root = new Node();
    static final int HIGH_BIT = 30;
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            insert(nums[i-1]);
            ans = Math.max(ans,check(nums[i]));
        }
        return ans;
    }

    public void insert(int num){
        Node cur = root;
        for (int i = HIGH_BIT; i >=0 ; i--) {
            int bit = (num >> i) & 1;
            if(bit == 0){
                if(cur.left == null){
                    cur.left = new Node();
                }
                cur = cur.left;
            }else {
                if(cur.right == null){
                    cur.right = new Node();
                }
                cur = cur.right;
            }
        }
    }

    public int check(int num){
        Node cur = root;
        int x = 0;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(bit == 0){
                if(cur.right != null){
                    cur = cur.right;
                    x = x*2+1;
                }else {
                    cur = cur.left;
                    x = x * 2;
                }
            }else {
                if(cur.left != null){
                    cur = cur.left;
                    x = x*2+1;
                }else {
                    cur = cur.right;
                    x = x * 2;
                }
            }
        }
        return x;
    }
    class Node{
        Node left = null;
        Node right = null;
    }
}
