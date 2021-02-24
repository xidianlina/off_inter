package main

/**
题目描述
一个整型数组里除了两个数字之外，其他的数字都出现了两次。
请写程序找出这两个只出现一次的数字。
*/
func FindNumsAppearOnce(nums []int) []int {
	//返回[a,b] 其中ab是出现一次的两个数字
	//write your code
	l := len(nums)
	if l < 2 {
		return []int{0, 0}
	}

	sum := 0
	for i := 0; i < l; i++ {
		sum ^= nums[i]
	}

	n := 1
	if (sum & n) == 0 {
		n <<= 1
	}

	res := make([]int, 2)
	for i := 0; i < l; i++ {
		if (nums[i] & n) != 0 {
			res[0] ^= nums[i]
		} else {
			res[1] ^= nums[i]
		}
	}

	return res
}
