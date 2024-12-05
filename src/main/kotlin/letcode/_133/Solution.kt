package br.com.lucolimac.letcode._133

class Solution {
    private val map = hashMapOf<Int, Node>()
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        if (map.containsKey(node.`val`)) return map[node.`val`]
        val nodeCopy = Node(node.`val`)
        map[node.`val`] = nodeCopy
        for (neighbor in node.neighbors) {
            nodeCopy.neighbors.add(cloneGraph(neighbor))
        }
        return nodeCopy
    }

    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList()
    }
}