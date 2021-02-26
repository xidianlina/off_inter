package main

/**
题目描述
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

示例1
输入
"123.45e+6"
返回值
true

示例2
输入
"1.2.3"
返回值
false
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 *
 * @param str string字符串
 * @return bool布尔型
 */
func isNumeric(str string) bool {
	// write code here
	l := len(str)
	if l == 0 || str == "" {
		return true
	}

	has_e, sign, decimal := false, false, false
	for i := 0; i < l; i++ {
		if str[i] == 'e' || str[i] == 'E' {
			if i == l-1 || has_e {
				return false
			}
			has_e = true
		} else if str[i] == '+' || str[i] == '-' {
			if sign && str[i-1] != 'e' && str[i-1] != 'E' {
				return false
			}
			if !sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E' {
				return false
			}
			sign = true
		} else if str[i] == '.' {
			if has_e || decimal {
				return false
			}
			decimal = true
		} else if str[i] < '0' || str[i] > '9' {
			return false
		}
	}
	return true
}
