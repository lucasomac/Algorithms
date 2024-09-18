package br.com.lucolimac.letcode._173

import java.util.Stack;

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BSTIterator(root: TreeNode?) {
    var stack: Stack<TreeNode>

    init {
        var father = root
        stack = Stack<TreeNode>()
        while (father != null) {
            stack.push(father)
            father = father.left
        }
    }

    fun next(): Int {
        var res = stack.pop()
        var cur = res
        if (cur?.right != null) {
            cur = cur.right
            while (cur?.right != null) {
                stack.push(cur)
                cur = cur.left
            }
        }
        return res!!.`val`
    }

    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }
}