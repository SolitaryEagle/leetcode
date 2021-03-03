package com.leetcode.程序员面试宝典.medium;

/**
 * @author 覃国强
 * @date 2020-09-17 18:15
 */
public class 面试题_05_08_绘制直线 {

    public static void main(String[] args) {


        int a = -1;
        System.out.println(Integer.toBinaryString(a));
        a = a >>> 30;
        System.out.println(Integer.toBinaryString(a));



    }

    static class Solution {

        /**
         * 需要考虑 x1,x2 同时在一个int中；和分别在两个 int 中的情况
         * @param length
         * @param w
         * @param x1
         * @param x2
         * @param y
         * @return
         */
        public int[] drawLine(int length, int w, int x1, int x2, int y) {
            int[] result = new int[length];

            int low = (y * w + x1) / 32;
            int high = (y * w + x2) / 32;
            for (int i = low; i <= high; ++i) {
                result[i] = -1;
            }

            int tmp = -1;

            result[low] = tmp >>> (x1 % 32);
            int tmpHigh = tmp << (32 - (x2 % 32) - 1);
            result[high] = result[high] & tmpHigh;

            return result;
        }

        public int[] drawLine2(int length, int w, int x1, int x2, int y) {
            int[] result = new int[length];

            int n = w / 32;
            int rowBegin = y * n;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                sb.append("00000000");
                sb.append("00000000");
                sb.append("00000000");
                sb.append("00000000");
            }
            sb.replace(x1, x2, getOneString(x2 - x1 + 1));

            for (int i = 0; i < n; ++i) {
                String binaryString = sb.substring(i * 32, i * 32 + 32);
                int integer = Integer.parseUnsignedInt(binaryString, 2);
                result[rowBegin++] = integer;
            }

            return result;
        }

        private String getOneString(int length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; ++i) {
                sb.append(1);
            }
            return sb.toString();
        }
    }

}
