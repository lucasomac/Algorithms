package br.com.lucolimac.letcode._7

class Solution {
    fun reverse(x: Int): Int {
        return try {
            if (x > 0) x.toString().reversed().toInt() else x.toString().reversed().replace("-", "").toInt() * -1
        } catch (ex: Exception) {
            0
        }
    }
}