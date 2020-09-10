package com.leetcode.程序员面试宝典;

/**
 * @author 覃国强
 * @date 2020-09-10 07:33
 */
public class 面试题_08_11_硬币 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.waysToChange(5));
        System.out.println(solution.waysToChange(10));

    }

    static class Solution {

        private static final int[] coins = {1, 5, 10, 25};

        public int waysToChange(int n) {

            int[][] dp = new int[4][n + 1];

            for (int j = coins[0]; j <= n; j += coins[0]) {
                dp[0][j] = 1;
            }

            for (int i = 0; i < dp.length; ++i) {
                dp[i][0] = 1;
            }

            for (int i = 1; i < dp.length; ++i) {
                for (int j = 1; j < dp[0].length; ++j) {
                    int tmp = j >= coins[i] ? dp[i][j - coins[i]] : 0;
                    dp[i][j] = (dp[i - 1][j] + tmp) % 1000000007;
                }
            }

            return dp[dp.length - 1][n];
        }
    }
}
