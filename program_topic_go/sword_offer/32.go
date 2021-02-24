package main

import (
	"bytes"
	"fmt"
	"sort"
	"strconv"
	"strings"
)

/**
题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

示例
输入
[3,32,321]
返回值
"321323"
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param numbers int整型一维数组
 * @return string字符串
 */
func PrintMinNumber(n []int) string {
	// write code here
	l := len(n)
	if l == 0 || n == nil {
		return ""
	}
	var str_arr []string
	for _, num := range n {
		str_arr = append(str_arr, strconv.Itoa(num))
	}

	sort.Slice(str_arr, func(i, j int) bool {
		if str_arr[i]+str_arr[j] < str_arr[j]+str_arr[i] {
			return true
		}
		return false
	})

	return strings.Join(str_arr, "")
}

func PrintMinNumber2(n []int) string {
	// write code here
	l := len(n)
	if l == 0 || n == nil {
		return ""
	}

	sort.Slice(n, func(i, j int) bool {
		str1 := fmt.Sprintf("%d%d", n[i], n[j])
		str2 := fmt.Sprintf("%d%d", n[j], n[i])
		if str1 < str2 {
			return true
		}
		return false
	})

	//把数组中的字符串依次拼接起来
	var res strings.Builder
	for i := 0; i < l; i++ {
		res.WriteString(fmt.Sprintf("%d", n[i]))
	}

	return res.String()
}

func PrintMinNumber3(n []int) string {
	// write code here
	l := len(n)
	if l == 0 || n == nil {
		return ""
	}

	sort.Slice(n, func(i, j int) bool {
		str1 := fmt.Sprintf("%d%d", n[i], n[j])
		str2 := fmt.Sprintf("%d%d", n[j], n[i])
		if str1 < str2 {
			return true
		}
		return false
	})

	//把数组中的字符串依次拼接起来
	var res bytes.Buffer
	for i := 0; i < l; i++ {
		res.WriteString(fmt.Sprintf("%d", n[i]))
	}

	return res.String()
}

func main() {
	arr := []int{3, 32, 321}
	res := PrintMinNumber(arr)
	fmt.Println(res)
	fmt.Println("---------")
	res = PrintMinNumber2(arr)
	fmt.Println(res)
	fmt.Println("---------")
	res = PrintMinNumber3(arr)
	fmt.Println(res)
}
