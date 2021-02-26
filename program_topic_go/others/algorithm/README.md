算法题目
======
# 1.减绳子
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

# 2.洗牌算法
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

# 3.完美洗牌算法
> 题目描述      
  有个长度为2n的数组{a1, a2, a3, ..., an, b1, b2, b3, ..., bn} ，
  希望排序后 {a1, b1, a2, b2, ...., an, bn} ，请考虑有无时间复杂度 O(n)，空间复杂度 O(1) 的解法。     
  分析和解法     
  解法一：蛮力变换      
  题目要求怎么变换就怎么变换。为了便于分析，取n=4，那么题目要求把     
  a1，a2，a3，a4， b1，b2，b3，b4      
  变成        
  a1，b1，a2，b2，a3，b3，a4，b4       
  1.1、步步前移
  仔细观察变换前后两个序列的特点，我们可做如下一系列操作：
  第①步、确定 b1 的位置，即让 b1 跟它前面的 a2，a3，a4 交换：        
  a1，b1，a2，a3，a4， b2，b3，b4            
  第②步、接着确定 b2 的位置，即让 b2 跟它前面的 a3，a4 交换：     
  a1，b1，a2，b2，a3，a4， b3，b4      
  第③步、b3 跟它前面的 a4 交换位置：     
  a1，b1，a2，b2，a3，b3，a4，b4       
  b4已在最后的位置，不需要再交换。如此，经过上述 3 个步骤后，得到我们最后想要的序列。      
  源代码如下:        
```go
func shuffle(arr []int) {
	l := len(arr)
	if l < 3 || l%2 == 1 {
		return
	}

	size, index, count := l/2, 0, 0
	for i := size; i < l-1; i++ {
		count = size - (i - size) - 1 //交换个数
		index = i                     //待交换的数的下标
		for j := 1; j <= count; j++ {
			arr[index], arr[i-j] = arr[i-j], arr[index]
			index = i - j
		}
	}
}
```
> 分析：但此方法的时间复杂度为O(N^2)，得继续寻找其它方法，看看有无办法能达到题目所预期的O(N)的时间复杂度。     
> 1.2、中间交换      
 当然，除了如上面所述的让 b1，b2，b3，b4 步步前移跟它们各自前面的元素进行交换外，还可以每次让序列中最中间的元素进行交换达到目的。
 还是用上面的例子，针对 a1，a2，a3，a4，b1，b2，b3，b4        
 第①步：交换最中间的两个元素 a4，b1，序列变成：     
 a1，a2，a3 ，b1，a4， b2，b3，b4      
 第②步，让最中间的两对元素各自交换：     
 a1，a2 ，b1，a3，b2，a4， b3，b4      
 第③步，交换最中间的三对元素，序列变成：       
 a1，b1，a2，b2，a3，b3，a4，b4        
 同样，此法同解法 1.1、步步前移一样，时间复杂度依然为 O（N^2）。       
 源代码如下：  
```go
func shuffle2(arr []int) {
	l := len(arr)
	if l < 3 || l%2 == 1 {
		return
	}

	n := l / 2
	left, right := n-1, n
	// 交换次数
	for i := 0; i < n-1; i++ {
		for j := left; j < right; j += 2 {
			arr[j], arr[j+1] = arr[j+1], arr[j]
		}
		left--
		right++
	}
}
``` 
> 解法二：完美洗牌算法        
  什么是完美洗牌问题呢？即给定一个数组        
  a1，a2，a3， …， an， b1， b2， b3， ...， bn           
  最终把它置换成       
  b1， a1， b2， a2， a3， b3，…， bn， an      
  这个完美洗牌问题本质上与本题完全一致，只要在完美洗牌问题的基础上对它最后的序列 swap 两两相邻元素即可。        
  2.1、位置置换 perfect_shuffle1 算法      
  (1).对原始位置的变化做如下分析：     
  ![shuffle](http://github.com/xidianlina/off_inter/raw/master/program_topic_go/others/algorithm/shuffle.jpg)   
> (2).依次考察每个位置的变化规律：     
  从上面的例子我们能看到，前 n 个元素中，     
  第 1 个元素 a1 到了原第 2 个元素 a2 的位置，即 1 -> 2；        
  第 2 个元素 a2 到了原第 4 个元素 a4 的位置，即 2 -> 4；        
  第 3 个元素 a3 到了原第 6 个元素 b2 的位置，即 3 -> 6；        
  第 4 个元素 a4 到了原第 8 个元素 b4 的位置，即 4 -> 8；        
  那么推广到一般情况即是：前 n 个元素中，第 i 个元素去了 第（2 * i）的位置。       
  上面是针对前 n 个元素，那么针对后 n 个元素，可以看出：        
  第 5 个元素 b1 到了原第 1 个元素 a1 的位置，即 5 -> 1；        
  第 6 个元素 b2 到了原第 3 个元素 a3 的位置，即 6 -> 3；        
  第 7 个元素 b3 到了原第 5 个元素 b1 的位置，即 7 -> 5；        
  第 8 个元素 b4 到了原第 7 个元素 b3 的位置，即 8 -> 7；        
  推广到一般情况是：后 n 个元素，第 i 个元素去了第 (2 * (i - n) ) - 1 = 2 * i - (2 * n + 1) = (2 * i) % (2 * n + 1) 的位置。     
  当 0 < i < n 时， 原式 = (2 * i) % (2 * n + 1) = 2 * i；        
  当 i > n 时，原式 (2 * i) % (2 * n + 1) 保持不变。          
  再综合到任意情况：任意的第 i 个元素，我们最终换到了 (2 * i) % (2 * n + 1) 的位置。                
  因此，如果题目允许我们再用一个数组的话，我们直接把每个元素放到该放得位置就好了。也就产生了最简单的方法 perfect_shuffle1 。        
  源代码如下:        
```go
func shuffle3(arr []int) {
	l := len(arr)
	if l < 3 || l%2 == 1 {
		return
	}

	res := make([]int, l)
	for i := 1; i < l-1; i++ {
		res[(2*i)%(l-1)] = arr[i]
	}

	for j := 1; j < l-1; j++ {
		arr[j] = res[j]
	}
}
```
> 分析：它的时间复杂度虽然是O(n)，但其空间复杂度却是O(n)，仍不符合本题所期待的时间O(n)，空间O(1)。
  2.2、完美洗牌算法 perfect_shuffle2       
  2.2.1、走圈算法 cycle_leader       
  根据上面变换的节奏，可以看出有两个圈      
  一个是1 -> 2 -> 4 -> 8 -> 7 -> 5 -> 1；       
  一个是3 -> 6 -> 3。       
  这两个圈可以表示为(1,2,4,8,7,5)和(3,6)，且perfect_shuffle1算法也已经告诉了我们，不管n是奇数还是偶数，每个位置的元素都将变为第(2*i)%(2n+1)个元素：        
  因此只要知道圈里最小位置编号的元素即圈的头部，顺着圈走一遍就可以达到目的，且因为圈与圈是不相交的，所以这样下来，刚好走了 O（N）步。       
  2.2.2、神级结论：若2*n=（3^k - 1），则可确定圈的个数及各自头部的起始位置      
  引用“A Simple In-Place Algorithm for In-Shuffle”论文的一个结论了，即对于2 * n = （3^k-1）这种长度的数组，恰好只有 k 个圈，且每个圈头部的起始位置分别是 1，3，9，...，3^(k-1)。      
  至此，完美洗牌算法的 “主体工程” 已经完工，只存在一个 “小” 问题：如果数组长度不是（3^k - 1）呢？       
  若2 * n != （3^k - 1），则总可以找到最大的整数m，使得m < n，并且2 * m = （3^k - 1）。             
  对于长度为 2 * m 的数组，整理元素后剩余的 2 *（n - m）长度，递归调用完美洗牌算法即可。       
  2.2.3、完美洗牌算法 perfect_shuffle3     
  从上文的分析过程中也就得出了我们的完美洗牌算法，其算法流程为：       
  输入数组　a[1..2 * n]      
  (1).找到 2 * m = 3^k - 1 使得 3^k <= 2 * n < 3^(k +1)     
  (2).把 a[m + 1..n + m]那部分循环移 m 位       
  (3).对每个 i = 0,1,2..k - 1，3^i 是个圈的头部，做 cycle_leader 算法，数组长度为 m，所以对 2 * m + 1 取模。       
  (4).对数组的后面部分a[2 * m + 1.. 2 * n] 继续使用本算法, 这相当于 n 减小了m。        
  2.2.4、perfect_shuffle2 算法解决其变形问题      
  原始问题要输出a1, b1, a2, b2……an, bn，而完美洗牌却输出的是b1, a1, b2, a2,……bn, an。      
  解决办法非常简单：交换两两相邻元素即可（当然，你也可以让原数组第一个和最后一个不变，中间的 2 * (n - 1) 项用原始的标准完美洗牌算法做），
  只是在完美洗牌问题时间复杂度 O(N) 空间复杂度 O(1) 的基础上再增加 O(N) 的时间复杂度，故总的时间复杂度 O(N) 不变，且理所当然的保持了空
  间复杂度 O(1) 。至此,问题得到了圆满解决！      
  源代码如下：  
```go
package main

import "fmt"

func main() {
	arr := []int{-1, 0, 2, 4, 6, 8, 1, 3, 5, 7, 9}
	perfect_shuffle(arr)
	fmt.Println(arr)
}

//完美洗牌算法
func perfect_shuffle(arr []int) {
	l := len(arr)
	n := (l - 1) / 2
	start := 0

	for n > 1 {
		//第1步：找到2*m = 3^k - 1，使得3^k <= len - 1 < 3^(k + 1)
		k, m := 0, 1

		//for (; (len - 1) / m >= 3; k++, m = m * 3) ;
		for (l-1)/m >= 3 {
			k++
			m = m * 3
		}

		m = m / 2

		//第2步：把数组中的A[m + 1,...,n + m]那部分循环右移m位
		right_rotate(arr, start, m, n)

		//第3步：对于长度为2*m的数组，刚好有k个圈，每个圈的头部为3^i
		i, t := 0, 1
		for i < k {
			cycle_leader(arr, t, m*2+1)
			i++
			t = t * 3
		}

		//第4步：对数组后面部分A[2m + 1,...,2n]继续递归上面3步
		start = start + m*2
		n = n - m
	}

	//n == 1时
	arr[1+start], arr[2+start] = arr[2+start], arr[1+start]
	for i := 1; i < l; i = i + 2 {
		arr[i], arr[i+1] = arr[i+1], arr[i]
	}
}

// 走圈算法
func cycle_leader(arr []int, start, mod int) {
	for i := start * 2 % mod; i != start; i = i * 2 % mod {
		arr[i], arr[start] = arr[start], arr[i]
	}
}

//翻转 start 开始位置 end 结束位置
func reverse(arr []int, start, end int) {
	for start < end {
		arr[start], arr[end] = arr[end], arr[start]
		start++
		end--
	}
}

func right_rotate(arr []int, start, m, n int) {
	//翻转前m位
	reverse(arr, start+m+1, start+n)

	//翻转剩余元素
	reverse(arr, start+n+1, start+n+m)

	//整体翻转
	reverse(arr, start+m+1, start+n+m)
}
```

参考：     
https://www.jianshu.com/p/9c841ad88ded
https://blog.csdn.net/a1439775520/article/details/97397557
-------------------

# 4.
# 5.
# 6.
# 7.
# 8.
# 9.
