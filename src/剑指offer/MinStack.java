package 剑指offer;

import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if(minStack.isEmpty() || minStack.peek() > x){
            minStack.push(x);
        }else {
            minStack.push(minStack.peek());
        }
        stack.push(x);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
