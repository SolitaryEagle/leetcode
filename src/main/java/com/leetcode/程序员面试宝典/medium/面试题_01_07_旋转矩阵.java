package com.leetcode.程序员面试宝典.medium;

/**
 * @author 覃国强
 * @date 2020-08-29 11:43
 */
public class 面试题_01_07_旋转矩阵 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        solution.rotate(matrix);

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("=======================");

        matrix = new int[][]{
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };

        solution.rotate(matrix);

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }

    }

    static class Solution {

        public void rotate(int[][] matrix) {

            if (matrix == null) {
                return;
            }
            for (int[] ints : matrix) {
                if (ints == null) {
                    return;
                }
            }

            int startI = 0;
            int startJ = 0;
            int endI = matrix.length - 1;
            int endJ = matrix.length - 1;
            int length = endI - startI;
            while (startI < endI) {

                int i = startI, j = startJ;
                do {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[length - j][i];
                    matrix[length - j][i] = matrix[length - i][length - j];
                    matrix[length - i][length - j] = matrix[j][length - i];
                    matrix[j][length - i] = tmp;
                    ++j;
                } while (j < endJ);

                ++startI;
                ++startJ;
                --endI;
                --endJ;
            }
        }
    }
}


