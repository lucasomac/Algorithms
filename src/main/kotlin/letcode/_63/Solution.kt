package br.com.lucolimac.letcode._63

import kotlin.collections.withIndex

class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val numberOfRows = obstacleGrid.size
        val numberOfColumns = obstacleGrid[0].size
        var dp = IntArray(numberOfColumns).apply {
            map { 0 }
        }
        dp[0] = if (obstacleGrid[0][0] == 0) 1 else 0
        for (column in 1..<numberOfColumns) {
            if (obstacleGrid[0][column] == 0) {
                dp[column] = dp[column - 1]
            }
        }
        for (row in 1..<numberOfRows) {
            dp[0] = if (obstacleGrid[row][0] == 0) dp[0] else 0
            for (column in 1..<numberOfColumns) {
                if (obstacleGrid[row][column] == 0) {
                    dp[column] = dp[column] + dp[column - 1]
                } else {
                    dp[column] = 0
                }
            }

        }
        return dp[numberOfColumns - 1]
    }
}