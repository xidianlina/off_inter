算法题目
======
### 1.减绳子
```go
package main

import (
	"fmt"
)

/**
题目描述
给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

解题思路
首先判断k[0]到k[m]可能有哪些数字，实际上只可能是2或者3。
当然也可能有4，但是4=2*2，所以简单些不考虑了。
5<2*3,6<3*3,比6更大的数字就更不用考虑了，肯定要继续分。
其次看2和3的数量，2的数量肯定小于3个，为什么呢？
因为2*2*2<3*3，那么题目就简单了。
直接用n除以3，根据得到的余数判断是一个2还是两个2还是没有2就行了。
由于题目规定m>1，所以2只能是1*1，3只能是2*1，这两个特殊情况直接返回就行了。
 */
func cuttingRope(n int) int {
	if n <= 3 {
		return n - 1
	}

	x, y := n%3, n/3
	if x == 0 {
		return pow_helper(3, y)
	} else if x == 1 {
		return 2 * 2 * pow_helper(3, y-1)
	} else {
		return 2 * pow_helper(3, y)
	}
}

func pow_helper(n, m int) int {
	if m == 0 {
		return 1
	}
	r := n
	for i := 1; i < m; i++ {
		r *= n
	}
	return r
}

func main() {
	res := cuttingRope(4)
	fmt.Println(res)
}
```

### 2.洗牌算法
> 解题思路:     
  Fisher-Yates 洗牌算法，在每次迭代中，生成一个范围在当前下标到数组末尾元素下标之间的随机整数。
  接下来，将当前元素和随机选出的下标所指的元素互相交换
```go
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
```

### 3.完美洗牌算法



### 4.
### 5.
### 6.
### 7.
### 8.
### 9.