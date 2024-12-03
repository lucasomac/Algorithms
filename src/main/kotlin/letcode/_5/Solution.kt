package br.com.lucolimac.letcode._5


class Solution {
    fun longestPalindrome(s: String): String {
        if (s.isPalindrome()) return s
        var longestPalindrome = ""
        for (index in 1..<s.length) {
            var left = index
            var right = index
            while (s.substring(left, right + 1).isPalindrome()) {
                left--
                right++
                if (left == -1 || right == s.length) break
            }
            var palindrome = s.substring(left + 1, right)
            if (palindrome.length > longestPalindrome.length) longestPalindrome = palindrome
            left = index - 1
            right = index
            while (s.substring(left, right + 1).isPalindrome()) {
                left--
                right++
                if (left == -1 || right == s.length) break
            }
            palindrome = s.substring(left + 1, right)
            if (palindrome.length > longestPalindrome.length) longestPalindrome = palindrome
        }
        return longestPalindrome
    }

    private fun String.isPalindrome() = this == this.reversed()
}