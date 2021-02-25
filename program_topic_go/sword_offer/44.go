package main

import (
	"fmt"
	"strings"
)

/**题目描述
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

示例
输入
"nowcoder. a am I"
返回值
"I am a nowcoder."
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param ReverseSentence string字符串
 * @return string字符串
 */
func ReverseSentence(str string) string {
	// write code here
	str = strings.TrimSpace(str)

	str_arr := strings.Split(str, " ")
	var res []string
	for i := len(str_arr) - 1; i >= 0; i-- {
		res = append(res, str_arr[i])
	}
	return strings.Join(res, " ")
}

func ReverseSentence2(str string) string {
	// write code here
	str_arr := strings.Split(str, " ")
	var res []string
	for i := len(str_arr) - 1; i >= 0; i-- {
		s := strings.TrimSpace(str_arr[i])
		if len(s) > 0 {
			res = append(res, str_arr[i])
		}
	}
	return strings.Join(res, " ")
}

func ReverseSentence3(str string) string {
	// write code here
	l := len(str)
	if l == 0 || str == "" {
		return str
	}

	tmp, res := "", ""
	for i := 0; i < l; i++ {
		if str[i] == ' ' {
			res = " " + tmp + res
			tmp = ""
		} else {
			tmp += string(str[i])
		}
	}

	if len(tmp) > 1 {
		res = tmp + res
	}

	return res
}

func main() {
	str := "nowcoder. a am I"
	res := ReverseSentence(str)
	fmt.Println(res)
	fmt.Println("--------------")
	res = ReverseSentence2(str)
	fmt.Println(res)
	fmt.Println("--------------")
	res = ReverseSentence2(str)
	fmt.Println(res)
}
