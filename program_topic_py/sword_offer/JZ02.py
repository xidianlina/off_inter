# 题目描述
# 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
# 示例1
# 输入
# "We Are Happy"
# 复制
# "We%20Are%20Happy"

class Solution:
    def replaceSpace(self, s):
        # write code here
        l = list(s)
        size = len(l)
        if size == 0 or l == None:
            return ""

        res = ""
        for i in range(0, size):
            if l[i] == ' ':
                res += '%20'
            else:
                res += l[i]

        return res


class Solution2:
    def replaceSpace(self, s):
        # write code here
        l = list(s)
        size = len(l)
        if size == 0 or s == None:
            return ""

        replaceLen = 0
        for i in range(0, size):
            if l[i] == ' ':
                replaceLen = replaceLen + 1

        oldIndex, newIndex, oldLen, newLen = 0, 0, size, size + 2 * replaceLen
        res = list()
        while newIndex < newLen and oldIndex < oldLen:
            if l[oldIndex] == ' ':
                res.append('%')
                res.append('2')
                res.append('0')
                newIndex = newIndex + 2
            else:
                res.append(l[oldIndex])

            oldIndex = oldIndex + 1

        return "".join(res)


if __name__ == '__main__':
    s = "We Are Happy"
    l = list(s)
    print(l)
    solution = Solution()
    res = solution.replaceSpace(s)
    print(res)

    solution2 = Solution2()
    res = solution2.replaceSpace(s)
    print(res)
