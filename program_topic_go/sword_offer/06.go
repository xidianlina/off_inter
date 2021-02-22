package main

import "fmt"

/**
题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

示例
输入
[3,4,5,1,2]
返回值
1
*/

/**
 *
 * @param rotateArray int整型一维数组
 * @return int整型
 */
func minNumberInRotateArray(rotateArray []int) int {
	// write code here
	if len(rotateArray) == 0 {
		return -1
	}

	low := 0
	high := len(rotateArray) - 1
	mid := low // 如果第一个数字小于最后一个数字，那就说明该数组是有序的，直接返回第一个数字
	for rotateArray[low] >= rotateArray[high] {
		if high-low == 1 {
			mid = high
			break
		}

		mid = (low + high) >> 1
		// 如果第一个、最后一个和中间的数字都相等，那么只能按照顺序查找
		if rotateArray[low] == rotateArray[low] && rotateArray[mid] == rotateArray[high] {
			res := rotateArray[low]
			for i := low + 1; i <= high; i++ {
				if rotateArray[i] < res {
					res = rotateArray[i]
				}
			}
			return res
		}

		if rotateArray[mid] >= rotateArray[high] {
			low = mid
		} else if rotateArray[mid] <= rotateArray[high] {
			high = mid
		}
	}
	return rotateArray[mid]
}

func main() {
	nums := []int{1, 1, 1, 1, 0, 1, 1}
	res := minNumberInRotateArray(nums)
	fmt.Println(res)
}
