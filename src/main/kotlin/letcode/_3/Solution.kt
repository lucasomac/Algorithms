package br.com.lucolimac.letcode._3

class Solution {
    fun lengthOfLongestSubstring(input: String): Int {
        val inputLength = input.length
        var maxLength = 0
        val charIndexMap = HashMap<Char, Int>() // current index of character
        var startIndex = 0

        for (currentIndex in 0 until inputLength) {

            println("Before --> Start Index: $startIndex | Max Length: $maxLength | Index Actual: $currentIndex")
            // If the character is already in the map, update the start index
            if (charIndexMap.containsKey(input[currentIndex])) {
                startIndex = charIndexMap[input[currentIndex]]!!.coerceAtLeast(startIndex)
            }
            // Calculate the maximum length of the substring
            maxLength = maxLength.coerceAtLeast(currentIndex - startIndex + 1)
            // Update the character's index in the map
            charIndexMap[input[currentIndex]] = currentIndex + 1
            println("After  --> Start Index: $startIndex | Max Length: $maxLength | Index Actual: $currentIndex")
        }
        return maxLength
    }
}