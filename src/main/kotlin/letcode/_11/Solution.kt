package br.com.lucolimac.letcode._11

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {
        var first = 0
        var last = height.lastIndex
        var volContainer = 0
        while (first < last) {
            println("Vol: $volContainer, First: $first, Last: $last")
            volContainer = max(volContainer, min(height[first], height[last]) * (last - first))
            println("Vol: $volContainer, First: $first, Last: $last")
            if (height[first] > height[last]) last-- else first++
            println("Vol: $volContainer, First: $first, Last: $last")
            println("--------------------------------------------------------")
        }
        return volContainer
    }
}