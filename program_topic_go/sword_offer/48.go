package main

/**
题目描述
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。

示例
输入
1,2
返回值
3
*/

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 * @param num1 int整型
 * @param num2 int整型
 * @return int整型
 */

/**
用异或可以模拟不带进位的加法运算, 因为异或相同则0, 不同则1, 正好与不带进位的加法结果相同
用与运算可以模拟出每一位的是否有进位

用位运算来实现:
1.进行异或运算，计算两个数各个位置上的相加，不考虑进位；
2.进行位与运算，然后左移一位，计算进位值；
3.把异或运算的结果赋给num1，把进位值赋给num2，依此循环，进位值为空的时候结束循环，num1就是两数之和。
*/
func Add(num1 int, num2 int) int {
	// write code here
	if num2 == 0 {
		return num1
	}

	sum, carry := 0, 0
	for num2 != 0 {
		sum = num1 ^ num2
		carry = (num1 & num2) << 1
		num1 = sum
		num2 = carry
	}

	return num1
}
