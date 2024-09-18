package br.com.lucolimac.letcode._399

class Solution {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val graph = hashMapOf<String, HashMap<String, Double>>()
        for (i in equations.indices) {
            val equation = equations[i]
            val value = values[i]
            val (dividend, divisor) = equation
            graph.getOrPut(dividend) { hashMapOf() }[divisor] = value
            graph.getOrPut(divisor) { hashMapOf() }[dividend] = 1 / value
        }
        val result = DoubleArray(queries.size)
        for (i in queries.indices) {
            val query = queries[i]
            val (dividend, divisor) = query
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                result[i] = -1.0
                continue
            }
            if (dividend == divisor) {
                result[i] = 1.0
                continue
            }
            val visited = hashSetOf<String>()
            result[i] = dfs(graph, dividend, divisor, 1.0, visited)
        }
        return result
    }

    private fun dfs(
        graph: HashMap<String, HashMap<String, Double>>,
        current: String,
        target: String,
        value: Double,
        visited: HashSet<String>
    ): Double {
        if (current == target) return value
        visited.add(current)
        val neighbors = graph[current] ?: return -1.0
        for (neighbor in neighbors.keys) {
            if (visited.contains(neighbor)) continue
            val result = dfs(graph, neighbor, target, value * neighbors[neighbor]!!, visited)
            if (result != -1.0) return result
        }
        return -1.0
    }
}