package main

/**
题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
窗口大于数组长度的时候，返回空

示例
输入
[2,3,4,2,6,2,5,1],3
返回值
[4,4,6,6,6,5]
*/

/**
 *
 * @param num int整型一维数组
 * @param size int整型
 * @return int整型一维数组
 */
func maxInWindows(num []int, size int) []int {
	// write code here
	l := len(num)
	if l < size || size == 0 || num == nil {
		return []int{}
	}

	var res []int
	for i := 0; i < l-size+1; i++ {
		m := num[i]
		for j := i; j < i+size; j++ {
			if m < num[j] {
				m = num[j]
			}
		}
		res = append(res, m)
	}

	return res
}
