package com.leetcode.程序员面试宝典;

/**
 * @author 覃国强
 * @date 2020-09-19 20:01
 */
public class 面试题_16_09_运算 {

    public static void main(String[] args) {
/*

["Operations","divide","divide","divide","minus","multiply","minus","minus","divide","minus","multiply","divide","multiply","minus","divide"]
[[],[-1685428,2019555478],[-3,-518342492],[4,-59845],[5,659281762],[-36,-153],[3,-7],[8678,4757085],[-1491417400,1228184586],[1739816398,-7],[-5,685],[68035,61503977],[-25783,13250],[811576173,5810],[-59925123,73357676]]

 */


        Operations operations = new Operations();
        int divide = operations.divide(-1491417400, 1228184586);
        System.out.println(divide);

    }


    static class Operations {

        public Operations() {

        }

        public int minus(int a, int b) {
            b = (~b) + 1;
            return a + b;
        }

        public int multiply(int a, int b) {
            if (a == 0 || b == 0) {
                return 0;
            }

            int sign;
            if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
                sign = 1;
            } else {
                sign = -1;
            }

            if (a < 0) {
                a = (~a) + 1;
            }
            if (b < 0) {
                b = (~b) + 1;
            }

            if (a == 1 || b == 1) {
                return sign * (a == 1 ? b : a);
            }

            int result = 0;
            int length = a < b ? a : b;
            int base = a < b ? b : a;
            for (int i = 0; i < length; ++i) {
                result += base;
            }
            return result * sign;

        }

        public int divide(int a, int b) {
            if (a == 0 || b == 0) {
                return 0;
            }
            int sign;
            if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
                sign = 1;
            } else {
                sign = -1;
            }

            if (a < 0) {
                a = (~a) + 1;
            }
            if (b < 0) {
                b = (~b) + 1;
            }

            if (b == 1) {
                return a * sign;
            }

            int result = 0;
            int base = a;
            int tmp = (~b) + 1;
            while (base >= b) {
                ++result;
                base += tmp;
            }

            return result * sign;
        }
    }

}
