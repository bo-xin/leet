package 数组;

import java.util.Arrays;
import java.util.Comparator;

/*
给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。

第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。

返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。

输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
输出：[3,3,7]
解释：
1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
2) 1 XOR 2 = 3.
3) 5 XOR 2 = 7.

 */
public class leet1707 {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int n1 = queries.length;
        int[][] newQueries = new int[n1][3];
        for(int i = 0;i<n1;i++){
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] =queries[i][1];
            newQueries[i][2] = i;
        }
        Arrays.sort(newQueries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int[] answer = new int[queries.length];
        Trie trie = new Trie();
        int idx = 0,n = nums.length;
        for(int[] query:newQueries ){
            int x = query[0], m = query[1], qid = query[2];
            while (idx<n && nums[idx]<=m){
                trie.insert(nums[idx]);
                idx++;
            }
            if(idx == 0){
                answer[qid] = -1;
            }else {
                answer[qid] = trie.getMaxXor(x);
            }
        }
        return answer;
    }
    class Trie{
        static final int L = 30;
        Trie[] children = new Trie[2];
        public void insert(int val){
            Trie node = this;
            for(int i = L-1;i>=0;i--){
                int bit = (val>>i)&1;
                if(node.children[bit] == null){
                    node.children[bit] = new Trie();
                }
                node=node.children[bit];
            }
        }
        public int getMaxXor(int val){
            int ans = 0;
            Trie node = this;
            for(int i = L-1;i>=0 ; i--){
                int bit = (val>>i)&1;
                if (node.children[bit ^ 1] != null){
                    ans |= 1<<i;
                    bit ^=1;
                }
                node = node.children[bit];
            }
            return ans;
        }
    }
}
