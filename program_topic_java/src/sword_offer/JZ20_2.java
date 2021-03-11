package sword_offer;

import java.util.Stack;

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class JZ20_2 {
    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> m = new Stack<Integer>();

    public void push(int node) {
        s.push(node);
        if (m.empty()) {
            m.push(node);
        } else if (s.peek() > node) {
            m.push(node);
        }
    }

    public void pop() {
        if (s.peek() == m.peek()) {
            m.pop();
        }
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return m.peek();
    }
}
