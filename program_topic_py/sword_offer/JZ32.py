class Solution:
    def PrintMinNumber(self, numbers):
        # write code here
        if not numbers:
            return ''
        self.quicksort(numbers, 0, len(numbers) - 1)
        for i in range(len(numbers)):
            numbers[i] = str(numbers[i])
        return ''.join(numbers)

    def quicksort(self, n, l, r):
        if l < r:
            index = self.partition(n, l, r)
            self.quicksort(n, l, index - 1)
            self.quicksort(n, index + 1, r)

    def partition(self, n, left, right):
        tmp = n[left]
        while left < right:
            while left < right and (str(tmp) + str(n[right])) <= (str(n[right]) + str(tmp)):
                right = right - 1
            n[left], n[right] = n[right], n[left]
            while left < right and (str(n[left]) + str(tmp)) <= (str(tmp) + str(n[left])):
                left = left + 1
            n[left], n[right] = n[right], n[left]
        return left


if __name__ == '__main__':
    l = [3, 32, 321]
    s = Solution()
    r = s.PrintMinNumber(l)
    print(r)

