package com.leetcode.程序员面试宝典;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 覃国强
 * @date 2020-08-29 13:30
 */
public class 面试题_01_08_零矩阵 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        solution.setZeroes(matrix);

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("================");

        matrix = new int[][]{
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };

        solution.setZeroes(matrix);

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }

    }

    static class Solution {

        static class Coordinate {

            int x;
            int y;

            Coordinate(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public void setZeroes(int[][] matrix) {

            if (matrix == null) {
                return;
            }
            for (int[] ints : matrix) {
                if (ints == null) {
                    return;
                }
            }

            List<Coordinate> coordinates = new ArrayList<>();

            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[i].length; ++j) {
                    if (matrix[i][j] == 0) {
                        coordinates.add(new Coordinate(i, j));
                    }
                }
            }

            for (Coordinate coordinate : coordinates) {
                for (int i = 0; i < matrix.length; ++i) {
                    matrix[i][coordinate.y] = 0;
                }
                Arrays.fill(matrix[coordinate.x], 0);
            }

        }
    }

}
