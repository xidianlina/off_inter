package main

/**
题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
超过数组长度的一半，因此输出2。如果不存在则输出0。

示例
输入
[1,2,3,2,2,2,5,4,2]
返回值
2
*/

/**
 *
 * @param numbers int整型一维数组
 * @return int整型
 */

/**
数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现次数的和还要多。
因此在遍历数组的时候保存两个值：一个是数组中的一个数字，一个是次数，当遍历到下一个数字时，
如果下一个数字和之前保存的数字相同，则次数加1；如果下一个数字和之前保存的数字不同，则次数减1.如果次数为0，
需要保存下一个数字，并把次数设为1。由于要找的数字出现的次数比其他所有数字出现的次数之和还要多，
那么要找的数字肯定是最后一次次数设为1时对应的数字。
*/

func MoreThanHalfNum_Solution(nums []int) int {
	// write code here
	l := len(nums)
	if nums == nil || l == 0 {
		return 0
	}

	t := nums[0]
	cnt := 1
	for i := 1; i < l; i++ {
		if nums[i] == t {
			cnt++
		} else {
			cnt--
			if cnt == 0 {
				t = nums[i]
				cnt = 1
			}
		}
	}

	cnt = 0
	for i := 0; i < l; i++ {
		if t == nums[i] {
			cnt++
		}
	}

	if 2*cnt > l {
		return t
	} else {
		return 0
	}
}

func MoreThanHalfNum_Solution2(nums []int) int {
	// write code here
	l := len(nums)
	if nums == nil || l == 0 {
		return 0
	}

	low := 0
	high := l - 1
	mid := l >> 1
	index := partition(nums, low, high)
	for index != mid {
		if index > mid {
			high = index - 1
			index = partition(nums, low, high)
		} else if index < mid {
			low = index + 1
			index = partition(nums, low, high)
		}
	}

	res := nums[mid]
	cnt := 0
	for i := 0; i < l; i++ {
		if nums[i] == res {
			cnt++
		}
	}

	if 2*cnt > l {
		return res
	} else {
		return 0
	}
}

func partition(nums []int, low, high int) int {
	pivot := nums[low]
	for low < high {
		for low < high && nums[high] >= pivot {
			high--
		}
		nums[low] = nums[high]
		for low < high && nums[low] <= pivot {
			low++
		}
		nums[high] = nums[low]
	}
	nums[low] = pivot
	return low
}
