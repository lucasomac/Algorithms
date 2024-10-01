package br.com.lucolimac.letcode._917

class Solution {
    fun reverseOnlyLetters(s: String): String {
        var newString = s.toMutableList()
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (!newString[left].isLetter()) {
                left++
            } else {
                if (!newString[right].isLetter()) {
                    right--
                } else {
                    var aux = newString[left]
                    newString[left] = newString[right]
                    newString[right] = aux
                    left++
                    right--
                }
            }
        }
        return newString.joinToString("")
    }
}