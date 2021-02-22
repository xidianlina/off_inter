package leetcode

/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
详见：https://leetcode.com/problems/two-sum/description/

给定一个整数数组，找出其中两个数满足相加等于你指定的目标数字。

要求：这个函数twoSum必须要返回能够相加等于目标数字的两个数的索引，且index1必须要小于index2
*/
func twoSum(nums []int, target int) []int {
	res := make([]int, 2)
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			if nums[i]+nums[j] == target {
				res[0] = i
				res[1] = j
			}
		}
	}
	return res
}
