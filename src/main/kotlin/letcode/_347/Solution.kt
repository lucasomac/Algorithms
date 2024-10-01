package br.com.lucolimac.letcode._347

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        var listOfTop: List<MutableList<Int>> = List(nums.size + 1) { mutableListOf<Int>() }
        map.forEach { key, value ->
            listOfTop[value].add(key)
        }
        var result = mutableListOf<Int>()
        for (freq in nums.size downTo 1) {
            for (num in listOfTop[freq]) {
                result.add(num)
                if (result.size == k) return result.toIntArray()
            }
        }
        return result.toIntArray()
    }
}

fun main(args: Array<String>) {
    print(Solution().topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2))
}