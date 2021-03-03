package com.leetcode.程序员面试宝典.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 覃国强
 * @date 2020-09-09 07:21
 */
public class 面试题_08_08_有重复字符串的排列组合 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String S = "OSS";
        String[] permutation = solution.permutation(S);
        System.out.println(Arrays.toString(permutation));
    }

    static class Solution {

        public String[] permutation(String S) {

            if (S == null || S.length() == 0) {
                return new String[0];
            }

            if (S.length() == 1) {
                return new String[]{S};
            }

            List<String> result = new ArrayList<>();
            permutation(S.toCharArray(), 0, S.length(), result);
            return result.toArray(new String[0]);
        }

        private void permutation(char[] chars, int k, int length, List<String> result) {
            if (k == length - 1) {
                result.add(new String(chars));
            } else {
                Set<Character> tmp = new HashSet<>();
                for (int i = k; i < length; ++i) {
                    if (tmp.add(chars[i])) {
                        swap(chars, k, i);
                        permutation(chars, k + 1, length, result);
                        swap(chars, k, i);
                    }
                }
            }
        }

        private void swap(char[] chars, int i, int j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }
}
