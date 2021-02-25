package main

import "fmt"

/**
题目描述
在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
也不知道每个数字重复几次。请找出数组中第一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

返回描述：
如果数组中有重复的数字，函数返回true，否则返回false。
如果数组中有重复的数字，把重复的数字放到参数duplication[0]中。（ps:duplication已经初始化，可以直接赋值使用。）
*/

func Duplicate(numbers []int, duplication *[1]int) bool {
	l := len(numbers)
	if l <= 1 || numbers == nil {
		return false
	}

	hash := make([]int, l)
	for i := 0; i < l; i++ {
		hash[numbers[i]]++
		if hash[numbers[i]] > 1 {
			duplication[0] = numbers[i]
			return true
		}
	}

	return false
}

func Duplicate2(numbers []int, duplication *[1]int) bool {
	l := len(numbers)
	if l <= 1 || numbers == nil {
		return false
	}

	//时间复杂度为O(1),空间复杂度为O(n)
	m := make(map[int]bool)
	for _, val := range numbers {
		if _, ok := m[val]; ok {
			duplication[0] = val
			return true
		}
		m[val] = true
	}

	return false
}

func main() {
	arr := []int{2, 3, 1, 0, 2, 5, 3}
	dup := [1]int{}
	res := Duplicate(arr, &dup)
	fmt.Println(res, dup)
	fmt.Println("-----------")
	res = Duplicate2(arr, &dup)
	fmt.Println(res, dup)
}
