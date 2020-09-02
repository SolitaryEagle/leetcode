package com.leetcode.程序员面试宝典;

import java.math.BigDecimal;

/**
 * @author 覃国强
 * @date 2020-09-02 08:10
 */
public class 面试题_05_02_二进制数转字符串 {


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.printBin(0.2868311060592532));
    }

    static class Solution {

        public String printBin(double num) {

            if (num < 0 || num > 1) {
                return "ERROR";
            }

            BigDecimal numDecimal = new BigDecimal(String.valueOf(num));
            BigDecimal factorDecimal = new BigDecimal("2");

            StringBuilder sb = new StringBuilder("0.");
            for (int i = 0; i < 32; ++i) {
                numDecimal = numDecimal.multiply(factorDecimal);
                if (numDecimal.compareTo(BigDecimal.ONE) == 0) {
                    sb.append(1);
                    return sb.toString();
                } else if (numDecimal.compareTo(BigDecimal.ONE) > 0) {
                    numDecimal = numDecimal.subtract(BigDecimal.ONE);
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }

            return "ERROR";
        }
    }

}
