package main

import "fmt"

/**
题目描述
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）

示例
输入
"google"
返回值
4
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param str string字符串
 * @return int整型
 */
func FirstNotRepeatingChar(str string) int {
	// write code here
	l := len(str)
	if l == 0 || str == "" {
		return -1
	}

	arr := []byte(str)
	hash := make([]int, 256)
	for i := 0; i < l; i++ {
		hash[arr[i]]++
	}

	for i := 0; i < l; i++ {
		if hash[arr[i]] == 1 {
			return i
		}
	}

	return -1
}

func FirstNotRepeatingChar2(str string) int {
	// write code here
	l := len(str)
	if l == 0 || str == "" {
		return -1
	}

	hash := make(map[byte]int, 0)
	arr := []byte(str)
	for i := 0; i < l; i++ {
		if _, ok := hash[arr[i]]; ok {
			hash[arr[i]] = hash[arr[i]] + 1
		} else {
			hash[arr[i]] = 1
		}
	}

	for i := 0; i < l; i++ {
		if _, ok := hash[arr[i]]; ok && hash[arr[i]] == 1 {
			return i
		}
	}

	return -1
}

func main() {
	res := FirstNotRepeatingChar("google")
	fmt.Println(res)
	fmt.Println("----------------")
	res = FirstNotRepeatingChar2("google")
	fmt.Println(res)
}
