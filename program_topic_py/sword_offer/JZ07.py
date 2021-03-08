# 题目描述
# 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项(从0开始，第0项为0，第1项是1)。n≤39
#
# 示例
# 输入
# 4
# 返回值
# 3

# -*- coding:utf-8 -*-
class Solution:
    def Fibonacci(self, n):
        # write code here
        if n <= 1:
            return n
        return self.Fibonacci(n - 1) + self.Fibonacci(n - 2)

    def Fibonacci2(self, n):
        if n <= 1:
            return n

        tmp, pre, res = 0, 0, 1
        for i in range(2, n + 1):
            tmp = res
            res = pre + res
            pre = tmp

        return res

    def Fibonacci3(self, n):
        res = [0, 1, 1, 2]
        while len(res) <= n:
            res.append(res[-1] + res[-2])

        return res[n]

    def Fibo(self, n, acc1, acc2):
        if n == 0:
            return 0

        if n == 1:
            return acc2
        else:
            return self.Fibo(n - 1, acc2, acc1 + acc2)

    def Fibonacci4(self, n):
        return self.Fibo(n, 0, 1)


if __name__ == '__main__':
    s = Solution()
    fi = s.Fibonacci(4)
    print(fi)
    fi2 = s.Fibonacci2(4)
    print(fi2)
    fi3 = s.Fibonacci3(4)
    print(fi3)
    fi4 = s.Fibonacci4(4)
    print(fi4)
