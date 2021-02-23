package main

/**
题目描述
输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
求所有子数组的和的最大值。要求时间复杂度为 O(n).

示例
输入
[1,-2,3,10,-4,7,2,-5]
返回值
18

说明
输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和18。
*/

/**
 *
 * @param array int整型一维数组
 * @return int整型
 */

/**
注意题目描述，有正数有负数，如果允许无非负数，那么需要单独考虑。
原理：如果前几个数加和小于零，那么前面的数所做的全是无用功所以清零
*/
func FindGreatestSumOfSubArray(array []int) int {
	// write code here
	l := len(array)
	if l == 0 || array == nil {
		return -1
	}

	sum, max_sum := array[0], array[0]
	for i := 1; i < l; i++ {
		if sum <= 0 {
			sum = array[i]
		} else {
			sum += array[i]
		}

		if sum > max_sum {
			max_sum = sum
		}
	}

	return max_sum
}

func FindGreatestSumOfSubArray2(array []int) int {
	// write code here
	l := len(array)
	if l == 0 || array == nil {
		return -1
	}

	max_sum := array[0]
	for i := 0; i < l; i++ {
		sum := 0
		for j := i; j < l; j++ {
			sum += array[j]
			if sum > max_sum {
				max_sum = sum
			}
		}
	}

	return max_sum
}
