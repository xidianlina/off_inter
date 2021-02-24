package main

/**
题目描述
统计一个数字在升序数组中出现的次数。

示例
输入
[1,2,3,3,3,3,4,5],3
返回值
4
*/

/**
 *
 * @param data int整型一维数组
 * @param k int整型
 * @return int整型
 */
func GetNumberOfK(data []int, k int) int {
	// write code here
	l := len(data)
	if l == 0 || data == nil {
		return 0
	}

	index, low, high, mid := 0, 0, l-1, 0
	for low < high {
		mid = (low + high) >> 1
		if data[mid] == k {
			index = mid
			break
		} else if data[mid] > k {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}

	cnt := 0
	for i := index; i < l; i++ {
		if data[i] == k {
			cnt++
		}
	}

	for i := index - 1; i >= 0; i-- {
		if data[i] == k {
			cnt++
		}
	}

	return cnt
}
