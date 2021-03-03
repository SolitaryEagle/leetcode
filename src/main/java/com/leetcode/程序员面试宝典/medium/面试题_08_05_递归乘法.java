package com.leetcode.程序员面试宝典.medium;

/**
 * @author 覃国强
 * @date 2020-09-08 07:45
 */
public class 面试题_08_05_递归乘法 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply(3, 4));
        System.out.println(solution.multiply(3, 10));
    }


    static class Solution {

        public int multiply(int A, int B) {

            if (A == 1 || B == 1) {
                return A == 1 ? B : A;
            }

            int max = Math.max(A, B);
            int min = Math.min(A, B);

            int res = doMultiply(max, min);

            return res;
        }

        private int doMultiply(int max, int min) {
            if (min == 1) {
                return max;
            }

            if ((min & 1) == 1) {
                return doMultiply(max, 1) + doMultiply(max, min - 1);
            }
            return doMultiply(max << 1, min >> 1);
        }
    }
}
