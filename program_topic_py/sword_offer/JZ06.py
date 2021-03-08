# 题目描述
# 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
# 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
# NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
# 示例1
# 输入
# [3,4,5,1,2]
# 返回值
# 1

# -*- coding:utf-8 -*-
class Solution:
    def minNumberInRotateArray(self, rotateArray):
        # write code here
        l = len(rotateArray)
        if l == 0:
            return -1

        low, high = 0, l - 1
        mid = low  # 如果第一个数字小于最后一个数字，那就说明该数组是有序的，直接返回第一个数字
        while rotateArray[low] >= rotateArray[high]:
            if high - low == 1:
                mid = high
                break

            mid = (low + high) >> 1
            # 如果第一个、最后一个和中间的数字都相等，那么只能按照顺序查找
            if rotateArray[low] == rotateArray[mid] and rotateArray[mid] == rotateArray[high]:
                res = rotateArray[low]
                for i in range(low + 1, high + 1):
                    if rotateArray[i] < res:
                        res = rotateArray[i]

                return res

            if rotateArray[mid] >= rotateArray[high]:
                low = mid

            if rotateArray[mid] <= rotateArray[high]:
                high = mid

        return rotateArray[mid]
