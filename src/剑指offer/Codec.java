package 剑指offer;

import java.util.*;

public class Codec {
    String NULL = "#";
    String ESP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serialize(root,sb);
        return sb.toString();
    }
    public void serialize(TreeNode root,StringBuffer sb){
        if(root == null){
            sb.append(NULL).append(ESP);
            return;
        }
        sb.append(root.val).append(ESP);
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for (String s : data.split(ESP)) {
            list.addLast(s);
        }
        return deserialize(list);
    }
    public TreeNode deserialize(LinkedList<String> nodes){
        if(nodes.isEmpty()) return null;
        String first = nodes.pollFirst();
        if(first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}