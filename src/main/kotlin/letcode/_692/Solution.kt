package br.com.lucolimac.letcode._692

class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        var map = mutableMapOf<String, Int>()
        words.forEach { word ->
            map[word] = map[word]?.let { it + 1 } ?: 1
        }
        return map.toList().groupBy { pair -> pair.second }.toSortedMap().toList().reversed()
            .associate { pair -> Pair(pair.first, pair.second.map { it.first }.sorted()) }.map { it.value }.flatten()
            .subList(0, k)
    }
}