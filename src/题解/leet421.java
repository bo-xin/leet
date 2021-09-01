package 题解;

import java.util.Arrays;

/*
给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。

进阶：你可以在 O(n) 的时间解决这个问题吗？

 */
public class leet421 {

    public int findMaximumXOR(int[] nums) {

        Trie trie = new Trie();
        int ans = 0;
        for(int i :nums){
            trie.insert(i);
            int j = trie.get(i);
            ans = Math.max(j,ans);
        }
        return ans;
    }
     class Trie{
        static final int L = 31;
        Trie[] children = new Trie[2];

        public void insert(int val){
            Trie node = this;
            for (int i = L-1; i >=0 ; i--) {
                int bit = (val>>i)&1;
                if(node.children[bit] == null){
                    node.children[bit] = new Trie();
                }
                node = node.children[bit];
            }
        }
        public int get(int val){
            int ans = 0;
            Trie node = this;
            for(int i=L-1;i>=0;i--){
                int bit = (val>>i)&1;
                if(node.children[bit ^ 1] != null){
                    ans |= 1<<i;
                    bit ^=1;
                }
                node=node.children[bit];
            }
            return ans;
        }
    }
}
