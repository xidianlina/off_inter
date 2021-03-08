# 题目描述
# 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
# 示例
# 输入
# 3
# 返回值
# 4

# -*- coding:utf-8 -*-
class Solution:
    def jumpFloorII(self, n):
        # write code here
        if n <= 1:
            return 1

        res = 1
        for i in range(1, n):
            res += self.jumpFloorII(n - i)

        return res
