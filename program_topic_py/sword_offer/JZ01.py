# -*- coding:utf-8 -*-
class Solution:

    # array 二维列表
    def Find(self, target, array):
        # write code here
        r = len(array)
        l = len(array[0])
        i = 0
        j = l - 1
        while i < r and j >= 0:
            if array[i][j] < target:
                i += 1
            elif array[i][j] > target:
                j -= 1
            else:
                return True
        return False


if __name__ == '__main__':
    solution = Solution()
    target = 7
    arr = [[1, 2, 8, 9], [2, 4, 9, 12], [4, 7, 10, 13], [6, 8, 11, 15]]
    res = solution.Find(7, arr)
    print(res)
