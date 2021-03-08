# 题目描述
# 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

# -*- coding:utf-8 -*-
class Solution:
    def rectCover(self, n):
        # write code here
        if n <= 1:
            return n

        tmp, pre, res = 0, 1, 1
        for i in range(2, n + 1):
            tmp = res
            res = pre + res
            pre = tmp

        return res
