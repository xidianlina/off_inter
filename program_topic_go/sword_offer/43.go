package main

/**
题目描述
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！

示例
输入
"abcXYZdef",3
返回值
"XYZdefabc"
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param str string字符串
 * @param n int整型
 * @return string字符串
 */
func LeftRotateString(str string, n int) string {
	// write code here
	l := len(str)
	if l == 0 || str == "" {
		return ""
	}

	n %= l
	str = str + str
	return str[n : n+l]
}

func LeftRotateString2(str string, n int) string {
	// write code here
	l := len(str)
	if l == 0 || str == "" {
		return ""
	}

	n %= l
	s := str[0:n]
	e := str[n:]
	return e + s
}

func LeftRotateString3(str string, n int) string {
	// write code here
	l := len(str)
	if l == 0 || str == "" {
		return ""
	}

	str_arr := []byte(str)
	reverse_arr(str_arr, 0, n-1)
	reverse_arr(str_arr, n, l-1)
	reverse_arr(str_arr, 0, l-1)

	return string(str_arr)
}

func reverse_arr(arr []byte, l, h int) {
	var tmp byte
	for l < h {
		tmp = arr[l]
		arr[l] = arr[h]
		arr[h] = tmp
		l++
		h--
	}
}
