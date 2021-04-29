package leetcode;

import java.util.*;

/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

说明：
所有输入均为小写字母。
 */
public class lc049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int size = strs.length;
        if (size < 1) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] arrayOfString = str.toCharArray();
            Arrays.sort(arrayOfString);
            String tmp = new String(arrayOfString);
            if (map.containsKey(tmp)) {
                map.get(tmp).add(str);
            } else {
                List<String> item = new ArrayList<>();
                item.add(str);
                map.put(tmp, item);
            }
        }

        for (List<String> value : map.values()) {
            result.add(value);
        }

        return result;
    }
}
