package br.com.lucolimac.letcode._1673

import java.util.Stack

class Solution {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        var stack: Stack<Int> = Stack()
        nums.forEachIndexed { index, num ->
            while (stack.isNotEmpty() && stack.peek() > num && stack.size + nums.size - index > k) {
                stack.pop()
            }
            if (stack.size < k) {
                stack.push(num)
            }
        }
        return stack.toList().toIntArray()
    }
}