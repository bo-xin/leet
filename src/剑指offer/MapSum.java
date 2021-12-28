package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leet
 * @description: 单词之和
 * @author: Tb
 * @create: 2021-12-13 11:01
 **/
public class MapSum {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int val;
    }

    TrieNode root;
    Map<String,Integer> map;
    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        TrieNode cur = root;
        int update = val;
        if(map.containsKey(key)){
            update = update - map.get(key);
        }
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if(cur.children[idx] == null){
                cur.children[idx] = new TrieNode();
            }
            cur.children[idx].val += update;
            cur = cur.children[idx];
        }
        map.put(key,val);
    }

    public int sum(String prefix) {
        int ans = 0;
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if(cur.children[idx] == null){
                return 0;
            }
            cur = cur.children[idx];
        }
        return cur.val;
    }
}
