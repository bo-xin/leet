package JavaIO;

import java.util.HashMap;
import java.util.Iterator;

public class LRU<K,V> implements Iterator<K> {

    private Node head;
    private Node tail;
    private HashMap<K, Node> map;
    private int maxSize;

    private class Node {

        Node pre;
        Node next;
        K k;
        V v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public K next() {
        return null;
    }
}
