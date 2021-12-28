package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leet
 * @description: 替换单词
 * @author: Tb
 * @create: 2021-12-12 17:45
 **/
public class offer2_63 {
    Node root =new Node();
    public String replaceWords(List<String> dictionary, String sentence) {
        for (String s : dictionary) {
            insert(s,root);
        }
        StringBuffer sb = new StringBuffer();
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if(isPrefix(strs[i],root)){
                strs[i] = replace(strs[i],root);
            }
            System.out.println(strs[i]);
            sb.append(strs[i]+" ");
        }
        return sb.toString().trim();
    }

    public class Node{
        Node[] c = new  Node[26];
        boolean end;
    }



    public void insert(String word,Node root){
        Node node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if(node.c[idx] == null){
                node.c[idx] = new Node();
            }
            node = node.c[idx];
        }
        node.end = true;
    }

    public boolean isPrefix(String pre,Node root){
        Node node = root;
        for (char c : pre.toCharArray()) {
            if(node.end) break;
            if(node.c[c-'a'] == null) return false;
            node = node.c[c-'a'];
        }
        return true;
    }
    public String replace(String word,Node root){
        StringBuffer sb = new StringBuffer();
        Node node = root;
        for (char c : word.toCharArray()) {
            if(node.end || node.c[c-'a'] == null) break;
            node = node.c[c-'a'];
            sb.append(c);
        }
        return sb.toString();
    }
}
