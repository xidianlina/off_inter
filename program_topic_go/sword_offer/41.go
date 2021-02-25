package main

/**
题目描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

返回值描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

示例
输入
9
返回值
[[2,3,4],[4,5]]
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param sum int整型
 * @return int整型二维数组
 */
func FindContinuousSequence(sum int) [][]int {
	// write code here
	if sum <= 1 {
		return [][]int{}
	}

	var res [][]int
	start, end := 1, 2
	for start != (1+sum)>>1 {
		cur_sum := (start + end) * (end - start + 1) / 2
		if cur_sum == sum {
			var arr []int
			for i := start; i <= end; i++ {
				arr = append(arr, i)
			}
			res = append(res, arr)
			start++
			end++
		} else if cur_sum < sum {
			end++
		} else {
			start++
		}
	}

	return res
}
