package com.leetcode.程序员面试宝典;

/**
 * @author 覃国强
 * @date 2020-09-17 18:15
 */
public class 面试题_05_08_绘制直线 {

    public static void main(String[] args) {

        System.out.println(Integer.parseUnsignedInt(Integer.toBinaryString(-1), 2));

        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.parseInt(Integer.toBinaryString(-1), 2));

    }

    static class Solution {

        public int[] drawLine(int length, int w, int x1, int x2, int y) {
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
