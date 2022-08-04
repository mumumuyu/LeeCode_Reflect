package example;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:    最小数的栈
 * 可以专门增加一个栈留存每次最小值
 * 执行用时：12 ms, 在所有 Java 提交中击败了97.57%的用户
 * 内存消耗：43.5 MB, 在所有 Java 提交中击败了39.37%的用户
 * @author: LGD
 * @date:2022/8/4 9:01
 */
class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
