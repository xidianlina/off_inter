# 题目描述
# 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

# 栈：栈特点是后进先出，即最后push进的元素最早pop出来。
# 队列：队列的特点是先进先出，第一个进入队列的元素将第一个出来
# 使用两个栈串联，可以实现先进先出。但是，得注意以下两点:
# 队列在入列时，stack2必须为空，stack1满员，保证顺序。
# 队列在出列时，stack1必须为空，stack2满员

# -*- coding:utf-8 -*-
stack1 = list()
stack2 = list()


class Solution:
    def push(self, node):
        # write code here
        stack1.append(node)

    def pop(self):
        # return xx
        if len(stack1) != 0 and len(stack2) == 0:
            while len(stack1) != 0:
                stack2.append(stack1.pop())

        if len(stack2) != 0:
            return stack2.pop()
