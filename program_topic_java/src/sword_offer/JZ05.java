package sword_offer;

import java.util.Stack;

/**
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class JZ05 {
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();

    public void push(int node) {
        stk1.push(node);
    }

    public int pop() {
        if (!stk1.isEmpty() && stk2.isEmpty()) {
            while (!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
        }
        return stk2.pop();
    }
}
