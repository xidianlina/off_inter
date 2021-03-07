# 题目描述
# 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
# 示例1
# 输入
# {67,0,24,58}
# 返回值
# [58,24,0,67]

# -*- coding:utf-8 -*-
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # 返回从尾部到头部的列表值序列，例如[1,2,3]
    def printListFromTailToHead(self, listNode):
        # write code here
        res = []
        if listNode is None:
            return res

        while listNode is not None:
            res.append(listNode.val)
            listNode = listNode.next

        return res[::-1]

    def printListFromTailToHead2(self, listNode):
        if listNode is None:
            return []
        return self.printListFromTailToHead2(listNode.next) + [listNode.val]

    def printListFromTailToHead3(self, listNode):
        if listNode is None:
            return []

        l = 0
        p = listNode
        while p is not None:
            l = l + 1
            p = p.next

        res = [0, ] * l
        p = listNode
        for i in range(l - 1, -1, -1):
            res[i] = p.val
            p = p.next
        return res


if __name__ == '__main__':
    for i in range(9, -1, -1):
        print(i, end='\t')

    for i in range(10)[::-1]:
        print(i, end='\t')
