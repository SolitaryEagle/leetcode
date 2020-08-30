package com.leetcode.程序员面试宝典;

/**
 * @author 覃国强
 * @date 2020-08-29 11:11
 */
public class 面试题_01_05_一次编辑 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String first = "pale";
        String second = "ple";
        System.out.println(solution.oneEditAway(first, second));

        first = "pales";
        second = "pal";
        System.out.println(solution.oneEditAway(first, second));

    }

    static class Solution {

        public boolean oneEditAway(String first, String second) {
            if (first == null && second == null) {
                return true;
            }
            if (first == null || second == null) {
                return false;
            }
            if (Math.abs(first.length() - second.length()) > 1) {
                return false;
            }

            String longStr = first.length() > second.length() ? first : second;
            String shortStr = first.length() > second.length() ? second : first;

            for (int i = 0, j = 0, diff = 0; i < longStr.length() && j < shortStr.length(); ++i, ++j) {
                if (longStr.charAt(i) != shortStr.charAt(j)) {
                    ++diff;
                    if (longStr.length() != shortStr.length()) {
                        --j;
                    }
                }
                if (diff > 1) {
                    return false;
                }
            }
            return true;
        }
    }

}
