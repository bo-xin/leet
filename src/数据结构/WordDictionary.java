package 数据结构;

public class WordDictionary {
    class Node{
        Node[] children = new Node[26];
        boolean isWord;
    }
    Node root = new Node();
    public WordDictionary() {

    }

    public void addWord(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int index =word.charAt(i)-'a';
            if(p.children[index] == null) p.children[index] = new Node();
            p = p.children[index];
        }
        p.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }
    public boolean dfs(String s, Node p, int sIdx){
        int n = s.length();
        if(n == sIdx) return p.isWord;
        char c = s.charAt(sIdx);
        if(c == '.'){
            for (int i = 0; i < 26; i++) {
                if(p.children[i] != null && dfs(s, p.children[i],sIdx+1)) return true;
            }
            return false;
        }else {
            int index = c - 'a';
            if(p.children[index] == null) return false;
            return dfs(s, p.children[index], sIdx+1);
        }
    }
}
