package com.leetcode.程序员面试宝典;

/**
 * @author 覃国强
 * @date 2020-09-10 08:21
 */
public class 面试题_08_14_布尔运算 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "1^0|0|1";

        System.out.println(solution.countEval(s, 0));

    }

    static class Solution {

        public int countEval(String s, int result) {

            if (s == null || s.length() <= 0) {
                return 0;
            }

            char[] chars = s.toCharArray();

            int[][][] dp = new int[chars.length][chars.length][2];

            for (int i = 0; i < chars.length; i += 2) {
                dp[i][i][0] = chars[i] == '0' ? 1 : 0;
                dp[i][i][1] = chars[i] == '1' ? 1 : 0;
            }

            // 已知对角线的值，需从对角线向上移动求值

            for (int j = 2; j < chars.length; j += 2) {
                for (int i = j - 2; i >= 0; i -= 2) {
                    for (int k = i + 1; k < j; k += 2) {
                        if (chars[k] == '&') {
                            dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0];
                            dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][1];
                            dp[i][j][0] += dp[i][k - 1][1] * dp[k + 1][j][0];

                            dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][1];
                        } else if (chars[k] == '|') {
                            dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0];

                            dp[i][j][1] += dp[i][k - 1][0] * dp[k + 1][j][1];
                            dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][0];
                            dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][1];
                        } else {
                            dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0];
                            dp[i][j][0] += dp[i][k - 1][1] * dp[k + 1][j][1];

                            dp[i][j][1] += dp[i][k - 1][0] * dp[k + 1][j][1];
                            dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][0];
                        }
                    }
                }
            }

            return dp[0][chars.length - 1][result];
        }
    }
}
