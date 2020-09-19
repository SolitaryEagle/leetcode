package com.leetcode.程序员面试宝典;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author 覃国强
 * @date 2020-09-19 19:13
 */
public class 面试题_16_06_最小差 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] a = {0};
        int[] b = {2147483647};

        System.out.println(solution.smallestDifference(a, b));

    }

    static class Solution {

        static class Wrapper {

            long value;

            int position;

            public Wrapper(long value, int position) {
                this.value = value;
                this.position = position;
            }
        }

        public int smallestDifference(int[] a, int[] b) {

            List<Wrapper> list = new ArrayList<>(a.length + b.length);

            for (int num : a) {
                list.add(new Wrapper(num, 0));
            }

            for (int num : b) {
                list.add(new Wrapper(num, 1));
            }

            list.sort(Comparator.comparingLong(o -> o.value));

            long min = Integer.MAX_VALUE;

            for (int i = 1; i < list.size(); ++i) {
                if (list.get(i - 1).position != list.get(i).position) {
                    long abs = Math.abs(list.get(i).value - list.get(i - 1).value);
                    min = Math.min(min, abs);
                }
            }

            return (int) min;
        }
    }
}
