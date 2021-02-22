package main

import (
	"fmt"
	"strings"
)

/**
题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*/

func ReplaceSpace(s string) string {
	//write your code here
	arr := []byte(s)
	var str_arr []string
	rep := "%20"
	for i := 0; i < len(arr); i++ {
		if string(arr[i]) == " " {
			str_arr = append(str_arr, rep)
		} else {
			str_arr = append(str_arr, string(arr[i]))
		}
	}

	return strings.Join(str_arr, "")
}

func ReplaceSpace2(s string) string {
	//write your code here
	arr := []byte(s)
	rep_len := 0
	for i := 0; i < len(arr); i++ {
		if string(arr[i]) == " " {
			rep_len++
		}
	}
	old_len := len(arr) - 1
	new_len := (old_len + 2*rep_len) - 1
	old_idx := 0
	new_idx := 0
	var str_arr []string
	for {
		if new_idx > new_len || old_idx > old_len {
			break
		}
		if string(arr[old_idx]) == " " {
			str_arr = append(str_arr, "%")
			str_arr = append(str_arr, "2")
			str_arr = append(str_arr, "0")
			new_idx = new_idx + 2
		} else {
			str_arr = append(str_arr, string(arr[old_idx]))
		}
		old_idx++
	}

	return strings.Join(str_arr, "")
}

func ReplaceSpace3(str, fill_str string) string {
	//write your code here
	str_len := len(str)
	fill_len := len(fill_str)
	if str_len == 0 || fill_len == 0 {
		return ""
	}

	//1.统计空格的个数，计算替换后字符串的总长度
	count := 0
	for i := 0; i < str_len; i++ {
		if str[i] == ' ' {
			count++
		}
	}

	if count == 0 {
		return str
	}

	//2.初始化一个足够长的切片
	length := count*fill_len - count
	s := make([]byte, length)
	res_str := append(StringToArray(str), s...)

	//3.遍历数组，移动非空格字符
	str_index := str_len - 1      // 标记字符串的末尾
	res_index := len(res_str) - 1 // 标记末尾处的空位
	for i := str_len - 1; i >= 0; i-- {
		if res_str[i] == ' ' {
			fillSubStr(res_str, res_index, fill_str)
			res_index -= fill_len
			str_index--
		} else {
			res_str[res_index] = res_str[str_index]
			str_index--
			res_index--
		}
	}

	return string(res_str)
}

// 将字符串转化为字节数组
func StringToArray(str string) []byte {
	arr := make([]byte, len(str))
	for i := 0; i < len(str); i++ {
		arr[i] = str[i]
	}
	return arr
}

func fillSubStr(s []byte, index int, sub_str string) {
	for j := len(sub_str) - 1; j >= 0; j-- {
		s[index] = sub_str[j]
		index--
	}
}

func main() {
	s := "We Are Happy"
	res := ReplaceSpace(s)
	fmt.Println(res)
	fmt.Println("-------------------")
	res = ReplaceSpace2(s)
	fmt.Println(res)
	fmt.Println("-------------------")
	fill_str := "%20"
	res = ReplaceSpace3(s, fill_str)
	fmt.Println(res)
}
