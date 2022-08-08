package order;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:    两个栈实现队列
 * 执行用时：62 ms, 在所有 Java 提交中击败了24.27%的用户
 * 内存消耗：48.7 MB, 在所有 Java 提交中击败了36.45%的用户
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

    //输出栈为空就拿输入栈
    public int deleteHead() {
        if(outputStack.isEmpty()){
            if(inputStack.isEmpty())
                return -1;
            while(!inputStack.isEmpty())
                outputStack.push(inputStack.pop());
        }

        return outputStack.pop();
    }
}
