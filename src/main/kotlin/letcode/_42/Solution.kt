package br.com.lucolimac.letcode._42

class Solution {
    fun trap(height: IntArray): Int {
        var highest = 0
        var water = IntArray(height.size)
        for (index in 0..<height.size) {
            if (height[index] > highest) highest = height[index]
            if (height[index] < highest) water[index] = water[index] + highest - height[index]
        }
        highest = 0
        for (index in height.size - 1 downTo 0) {
            if (height[index] > highest) highest = height[index]
            val diff = highest - height[index]
            if (diff < water[index]) water[index] = diff
        }
        return water.sum()
    }
}

fun main() {
    // Should be return 6
    println(Solution().trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    // Should be return 9
    println(Solution().trap(intArrayOf(4, 2, 0, 3, 2, 5)))
    // Should be return 1
    println(Solution().trap(intArrayOf(4, 2, 3)))
}


class Solution2 {
    fun trap(height: IntArray): Int {
        var l = 0
        var r = height.size - 1
        var l_m = 0
        var r_m = 0
        var result = 0

        while (l < r) {
            l_m = maxOf(l_m, height[l])
            r_m = maxOf(r_m, height[r])

            if (l_m < r_m) {
                result += l_m - height[l]
                l++
            } else {
                result += r_m - height[r]
                r--
            }
        }

        return result
    }
}