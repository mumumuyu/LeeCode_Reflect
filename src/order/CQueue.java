package order;

import java.util.Stack;

/**
 * @Description:    两个栈实现队列
 * @author: LGD
 * @date:2022/8/8 16:26
 */
class CQueue {

    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    public CQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void appendTail(int value) {
        inputStack.push(value);
    }

    public int deleteHead() {
        if(inputStack.size() == 0)
            return -1;
        for(Integer i : inputStack){
            outputStack.push(inputStack.pop());
        }
        return outputStack.pop();
    }
}
