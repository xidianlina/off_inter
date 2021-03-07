# 题目描述
# 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
# 示例1
# 输入
# 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
# 返回值
# true

# -*- coding:utf-8 -*-
class Solution:

    # array 二维列表
    def Find(self, target, array):
        # write code here
        row = len(array)
        col = len(array[0])
        i = 0
        j = col - 1
        while i < row and j >= 0:
            if array[i][j] < target:
                i = i + 1
            elif array[i][j] > target:
                j = j - 1
            else:
                return True

        return False


if __name__ == '__main__':
    solution = Solution()
    target = 7
    arr = [[1, 2, 8, 9], [2, 4, 9, 12], [4, 7, 10, 13], [6, 8, 11, 15]]
    res = solution.Find(7, arr)
    print(res)
