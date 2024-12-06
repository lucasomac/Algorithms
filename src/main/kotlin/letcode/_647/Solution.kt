package br.com.lucolimac.letcode._647

class Solution {
    private var count = 0
    fun countSubstrings(s: String): Int {
        for (left in s.indices) {
            for (right in left + 1..s.length) {
                println("The string is: ${s.substring(left, right)}")
                if (isPalindrome(s.substring(left, right))) {
                    count++
                }
            }
        }
        return count
    }

    private fun isPalindrome(word: String): Boolean {
        var left = 0
        var right = word.length - 1
        while (left != right && left < right) {
            if (word[left] == word[right]) {
                left++
                right--
            } else {
                return false
            }
        }
        return true
    }
}