package 剑指offer;

/**
 * @program: leet
 * @description: 实现前缀树
 * @author: Tb
 * @create: 2021-12-12 17:38
 **/
public class Trie {
    public class Node{
        Node[] c = new Node[26];
        boolean end;
    }
    private Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c -'a';
            if(node.c[index] == null){
                node.c[index] = new Node();
            }
            node = node.c[index];
        }
        node.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int idx = c -'a';
            if(node.c[idx] == null){
                return false;
            }
            node = node.c[idx];
        }
        return node.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            int idx = c -'a';
            if(node.c[idx] == null){
                return false;
            }
            node = node.c[idx];
        }
        return true;
    }
}
