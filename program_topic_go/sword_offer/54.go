package main

import "fmt"

/**
题目描述
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
返回值描述:
如果当前字符流没有存在出现一次的字符，返回#字符。
*/

var hash [256]int
var s string

func Insert(ch byte) {
	hash[ch]++
	s += string(ch)
}

func FirstAppearingOnce() byte {
	arr := []byte(s)
	for i := 0; i < len(arr); i++ {
		if hash[int(arr[i])] == 1 {
			return arr[i]
		}
	}
	return '#'
}

func main() {
	var c byte
	c = 48
	fmt.Println(c)
	i := int(c)
	fmt.Println(i)
}
