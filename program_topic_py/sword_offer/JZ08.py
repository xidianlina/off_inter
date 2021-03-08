# 题目描述
# 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
# 示例1
# 输入
# 1
# 返回值
# 1
#
# 示例2
# 输入
# 4
# 返回值
# 5

# -*- coding:utf-8 -*-
class Solution:
    def jumpFloor(self, n):
        # write code here
        if n <= 2:
            return n

        return self.jumpFloor(n - 1) + self.jumpFloor(n - 2)

    def jumpFloor2(self, n):
        if n == 1:
            return n

        tmp, pre, res = 0, 1, 1
        for i in range(2, n + 1):
            tmp = res
            res = pre + res
            pre = tmp

        return res


if __name__ == '__main__':
    s = Solution()
    r = s.jumpFloor(3)
    print(r)
    r2 = s.jumpFloor2(3)
    print(r2)
