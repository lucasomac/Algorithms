package br.com.lucolimac.letcode._122

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        for (index in 1..<prices.size) {
            if (prices[index] > prices[index - 1]) {
                maxProfit += prices[index] - prices[index - 1];
            }
        }
        return maxProfit
    }
}