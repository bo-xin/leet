package 剑指offer;

import java.util.*;

/**
 * @program: leet
 * @description: 最短单词编码
 * @author: Tb
 * @create: 2021-12-13 10:40
 **/
public class offer2_65 {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        int ans = 0;
        for (String s : set) {
            ans += s.length()+1;
        }
        return ans;
    }

    public int minimumLengthEncoding1(String[] words){
        TrieNode root = new TrieNode();
        Map<TrieNode,Integer> nodes = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode cur = root;
            for (int j = word.length()-1; j >= 0; j--) {
                cur = cur.get(word.charAt(j));
            }
            nodes.put(cur,i);
        }
        int ans = 0;
        for (TrieNode node : nodes.keySet()) {
            if(node.count == 0){
                ans += words[nodes.get(node)].length()+1;
            }
        }
        return ans;
    }
    class TrieNode{
        TrieNode[] children;
        int count;

        TrieNode(){
            children = new TrieNode[26];
            count = 0;
        }

        public TrieNode get(char c){
            if(children[c-'a'] == null){
                children[c-'a'] = new TrieNode();
                count++;
            }
            return children[c-'a'];
        }
    }
}
