package main

import "math/rand"

/**
解题思路:
  Fisher-Yates 洗牌算法，在每次迭代中，生成一个范围在当前下标到数组末尾元素下标之间的随机整数。
  接下来，将当前元素和随机选出的下标所指的元素互相交换
*/

type Solution struct {
	array []int
}

func Constructor(arr []int) Solution {
	return Solution{arr}
}

func (this *Solution) Reset() []int {
	return this.array
}

func (this *Solution) Shuffle() []int {
	l := len(this.array)
	res := make([]int, l)
	copy(res, this.array)
	for i := l - 1; i >= 0; i-- {
		// math.rand中的Intn(i+1)返回[0, i]范围的整数，每次数组在下标index为[0, i]范围内随机找一个下标对应的元素与当前位置i处的元素进行交换
		r := rand.Intn(i + 1)
		res[i], res[r] = res[r], res[i]
	}

	return res
}
