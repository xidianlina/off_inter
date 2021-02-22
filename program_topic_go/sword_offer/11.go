package main

import "fmt"

/**
题目描述
输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。

示例
输入
10
返回值
2
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param n int整型
 * @return int整型
 */

/**
利用&运算的特性,把一个整数减去1，再和原整数做与运算，
会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
*/

func NumberOf1(n int) int {
	// write code here
	res := 0
	for n != 0 {
		n &= (n - 1)
		res++
	}
	return res
}

/**
正整数的二进制数最高位为 0 ，负整数和二进制数最高们为 1 ，
则可利用左移、判断正负来实现 1 的个数的计算。
*/
func NumberOf1_2(n int) int {
	// write code here
	count := 0
	for n != 0 {
		if n < 0 {
			count++
		}
		n = n << 1 //左移一位,左边的最高位为符号位，根据正负数来判断符号位的0,1，从而得到1的个数
	}
	return count
}

/**
通过位移判断奇偶数并计数，标志位初始为1，将其和输入值相与，
n & 1 的结果为 1 或 0 ，为 1 的时候 count+=1 ，为 0 的时候 count+=0
*/
func NumberOf1_3(n int) int {
	// write code here
	count := 0
	flag := 1
	for flag != 0 {
		if (n & flag) != 0 {
			count++
		}
		flag = flag << 1
	}
	return count
}

func NumberOf1_4(n int) int {
	// write code here
	sum := 0
	num1 := fmt.Sprintf("%b", n)
	for _, char := range num1 {
		if char == '1' {
			sum++
		}
	}
	return sum
}

func main() {
	res := NumberOf1(10)
	fmt.Println(res)
	fmt.Println("--------")
	res = NumberOf1_2(10)
	fmt.Println(res)
	fmt.Println("--------")
	res = NumberOf1_3(10)
	fmt.Println(res)
	fmt.Println("--------")
	res = NumberOf1_4(10)
	fmt.Println(res)
}
