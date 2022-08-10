package example;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description:    栈的压入与弹出
 * 执行用时：4 ms, 在所有 Java 提交中击败了15.17%的用户
 * 内存消耗：41 MB, 在所有 Java 提交中击败了66.22%的用户
 * @author: LGD
 * @date:2022/8/10 14:40
 */
public class StackInOut {
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3}, new int[]{2, 1, 3}));
    }

    /**
     * 先进后出
     * 我这写的什么东西= = 通过测试用例：119 / 151 开摆开摆
     */
    public static boolean validateStackSequences_1(int[] pushed, int[] popped) {
        if (pushed == null || pushed.length < 3 || popped == null || popped.length < 3) return true;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pushed.length; i++) {
            map.put(pushed[i],i);
        }
        int max = map.get(popped[0]);//第一位
        for (int i = 1; i < popped.length-1; i++) {
            if (max < map.get(popped[i]))
                max = map.get(popped[i]);
            for (int j = i+1; j < popped.length; j++) {
                if(map.get(popped[i-1]) - map.get(popped[i]) == 1)
                    continue;
                if(map.get(popped[i]) < max && map.get(popped[i])<map.get(popped[j])){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num:pushed){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[i++]){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
