package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leet
 * @description: 剑指 Offer II 031. 最近最少使用缓存
 * @author: Tb
 * @create: 2021-12-01 10:00
 **/
public class LRUCache {
    Node head;
    Node tail;
    int cap;
    int size;
    Map<Integer,Node> map;
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(){}
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        cap = capacity;
        size = 0;
        map = new HashMap<>();
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        remove(node);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            moveToHead(newNode);
            ++size;
            if (size > cap){
                Node removeNode = tail.prev;
                map.remove(removeNode.key);
                remove(removeNode);
                --size;
            }
        }else {
            node.value = value;
            remove(node);
            moveToHead(node);
        }
    }
    public void moveToHead(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
}
