package com.leetcode.程序员面试宝典.medium;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 覃国强
 * @date 2020-09-03 07:56
 */
public class 面试题_05_04_下一个数 {

    public static void main(String[] args) {

        int num = ThreadLocalRandom.current().nextInt(100);




    }


    static class Solution {

        public int[] findClosedNumbers(int num) {
            int[] res = new int[2];

            int max = num + 1;
            while (Integer.bitCount(num) != Integer.bitCount(max)) {
                ++max;
            }
            res[0] = max;
            res[1] = -1;

            for (int min = num - 1; min > 0; --min) {
                if (Integer.bitCount(num) == Integer.bitCount(min)) {
                    res[1] = min;
                    return res;
                }
            }

            return res;
        }
    }

}
