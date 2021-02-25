package main

import "fmt"

/**
题目描述
LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小王可以看成任何数字,
并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。

示例
输入
[0,3,2,6,4]
返回值
true
*/

/**
 *
 * @param numbers int整型一维数组
 * @return bool布尔型
 */
func IsContinuous(nums []int) bool {
	// write code here
	l := len(nums)
	if nums != nil || l != 5 {
		return false
	}

	quick_sort(nums, 0, l-1)

	//记录每个数字之间差值的和
	sub := 0
	for i := 0; i < 4; i++ {
		if nums[i] == 0 {
			//continue 不进行下面的代码，进入下一次循环
			continue
		}
		//如果扑克牌（非0数字）重复，不是顺子
		if nums[i] == nums[i+1] {
			return false
		}
		//差值记录
		sub += nums[i+1] - nums[i]
	}
	//总的差值小于5（或sub<=4）则为顺子
	return sub < 5
}

func quick_sort(arr []int, l, h int) {
	pivot := 0
	if l < h {
		pivot = quick_partition(arr, l, h)
		quick_sort(arr, l, pivot-1)
		quick_sort(arr, pivot+1, h)
	}
}

func quick_partition(nums []int, low, high int) int {
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

func main() {
	arr := []int{0, 3, 2, 6, 4}
	quick_sort(arr, 0, len(arr))
	fmt.Println(arr)
}
