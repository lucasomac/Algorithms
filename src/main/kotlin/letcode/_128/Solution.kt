package br.com.lucolimac.letcode._128

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val setNums = nums.toSet()
        var longest = 0
        nums.forEach {
            if (it - 1 !in setNums) {
                var current = it
                var max = 1
                while (current + 1 in setNums) {
                    current += 1
                    max += 1
                }
                longest = maxOf(max, longest)
            }
        }
        return longest
    }
}