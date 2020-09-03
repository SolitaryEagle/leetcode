package com.leetcode.程序员面试宝典;

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

            StringBuilder sb = new StringBuilder("0.");
            for (int i = 0; i < 32; ++i) {
                num *= 2;
                if (num == 1) {
                    sb.append(1);
                    return sb.toString();
                } else if (num > 1) {
                    sb.append(1);
                    num -= 1;
                } else {
                    sb.append(0);
                }
            }

            return "ERROR";
        }

    }

}
