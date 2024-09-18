package br.com.lucolimac.letcode._9

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        val list = arrayListOf<Int>()
        getVal(head) { list.add(it) }
        return list == list.reversed()
    }

    fun getVal(head: ListNode?, add: (Int) -> Unit) {
        if (head == null) return
        else {
            add(head.`val`)
            getVal(head.next, add)
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}