package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
17. 电话号码的字母组合
给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
给出数字到字母的映射如下（与电话按键相同）。注意1不对应任何字母。

示例 1：
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

示例 2：
输入：digits = ""
输出：[]

示例 3：
输入：digits = "2"
输出：["a","b","c"]

提示：
0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class lc017 {
    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        result.add("");
        String[] btns = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            List<String> tmp = new ArrayList<>();
            String letter = btns[digits.charAt(i) - '0'];
            //遍历上一个列表，取出每一个元素，并和新的元素的每一个字符加起来保存
            for (int j = 0; j < result.size(); j++) {
                //遍历当前数字对应的所有字符
                for (int k = 0; k < letter.length(); k++) {
                    tmp.add(result.get(j) + letter.charAt(k));
                }
            }
            result = tmp;
        }
        return result;
    }
}
