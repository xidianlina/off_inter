package main

import "fmt"

/**
题目描述
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0

输入描述:
输入一个字符串,包括数字字母符号,可以为空

返回值描述:
如果是合法的数值表达则返回该数字，否则返回0

示例
输入
"+2147483647"
返回值
2147483647
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param str string字符串
 * @return int整型
 */
func StrToInt(str string) int {
	// write code here
	l := len(str)
	if l == 0 || str == "" {
		return 0
	}

	sum, sign := 0, 1
	if str[0] == '-' {
		sign = -1
	} else if str[0] == '+' {
		sign = 1
	} else if str[0] >= '1' && str[0] <= '9' {
		sum = int(str[0] - '0')
	} else {
		return 0
	}

	for i := 1; i < l; i++ {
		if str[i] < '1' || str[i] > '9' {
			return 0
		} else {
			sum = sum*10 + int(str[i]-'0')
		}
	}

	return sum * sign
}

func main() {
	str := "123"
	res := StrToInt(str)
	fmt.Println(res)
}
