package main

/**
题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

示例
输入
"ab"
返回值
["ab","ba"]
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param str string字符串
 * @return string字符串一维数组
 */

/**
以三个字符abc为例来分析一下求字符串排列的过程。首先固定第一个字符a，求后面两个字符bc的排列。
当两个字符bc的排列求好之后，把第一个字符a和后面的b交换，得到bac，接着固定第一个字符b，
求后面两个字符ac的排列。现在是把c放到第一位置的时候了。记住前面已经把原先的第一个字符a和后面的b做了交换，
为了保证这次c仍然是和原先处在第一位置的a交换，在拿c和第一个字符交换之前，先要把b和a交换回来。
在交换b和a之后，再拿c和处在第一位置的a进行交换，得到cba。再次固定第一个字符c，求后面两个字符b、a的排列。
*/
func Permutation(str string) []string {
	// write code here
	if len(str) == 0 {
		return []string{}
	}

	dict := map[string]bool{}
	s := []byte(str)

	var f func(index int)

	f = func(index int) {
		if index == len(s) {
			dict[string(s)] = true
			return
		}
		for i := index; i < len(str); i++ {
			tmp := s[index]
			s[index] = s[i]
			s[i] = tmp
			f(index + 1)
			s[i] = s[index]
			s[index] = tmp
		}
	}

	f(0)
	res := []string{}
	for k, _ := range dict {
		res = append(res, k)
	}
	return res
}
