package br.com.lucolimac.letcode._692

class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        var map = mutableMapOf<String, Int>()
        words.forEach { word ->
            map[word] = map[word]?.let { it + 1 } ?: 1
        }
        map.toSortedMap(compareBy<String> { it.length }.thenBy { it })
}