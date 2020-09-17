package com.leetcode.程序员面试宝典;

/**
 * @author 覃国强
 * @date 2020-09-17 13:19
 */
public class 面试题_10_09_排序矩阵查找 {


    static class Solution {

        public boolean searchMatrix(int[][] matrix, int target) {

            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            if (matrix.length == 1 && matrix[0].length == 1) {
                return matrix[0][0] == target;
            }

            Integer rowBegin = 0;
            Integer rowEnd = 0;
            Integer columnBegin = 0;
            Integer columnEnd = 0;

            int matrixBeginI = 0;
            int matrixBeginJ = 0;
            int matrixEndI = matrix.length - 1;
            int matrixEndJ = matrix[0].length - 1;

            while (matrixBeginI <= matrixEndI && matrixBeginJ <= matrixEndJ) {

                columnEnd = findLastLessThanTargetInRow(matrix, matrixBeginJ, matrixEndJ,
                    matrixBeginI, target);
                if (columnEnd == null) {
                    return true;
                }
                rowBegin = findFirstGreaterThanTargetInColumn(matrix, matrixBeginI, matrixEndI,
                    columnEnd, target);
                if (rowBegin == null) {
                    return true;
                }
                rowEnd = findLastLessThanTargetInColumn(matrix, matrixBeginI, matrixEndI,
                    matrixBeginJ, target);
                if (rowEnd == null) {
                    return true;
                }
                columnBegin = findFirstGreaterThanTargetInRow(matrix, matrixBeginJ, matrixEndJ,
                    rowEnd, target);
                if (columnBegin == null) {
                    return true;
                }

                if (rowBegin > rowEnd || columnBegin > columnEnd) {
                    return false;
                }

                if (rowBegin.equals(rowEnd)) {
                    return findEqualsTargetInOneRow(matrix, matrixBeginJ, matrixEndJ, rowBegin,
                        target);
                }
                if (columnBegin.equals(columnEnd)) {
                    return findEqualsTargetInOneColumn(matrix, matrixBeginI, matrixEndI,
                        columnBegin, target);
                }
                matrixBeginI = rowBegin;
                matrixEndI = rowEnd;
                matrixBeginJ = columnBegin;
                matrixEndJ = columnEnd;
            }
            return false;
        }

        private boolean findEqualsTargetInOneColumn(int[][] matrix, int matrixBeginI,
            int matrixEndI, Integer columnIndex, int target) {

            int begin = matrixBeginI;
            int end = matrixEndI;

            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (matrix[mid][columnIndex] == target) {
                    return true;
                } else if (matrix[mid][columnIndex] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }
            return false;
        }

        private boolean findEqualsTargetInOneRow(int[][] matrix, int matrixBeginJ,
            int matrixEndJ, Integer rowIndex, int target) {

            int begin = matrixBeginJ;
            int end = matrixEndJ;

            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (matrix[rowIndex][mid] == target) {
                    return true;
                } else if (matrix[rowIndex][mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }
            return false;
        }

        private Integer findFirstGreaterThanTargetInRow(int[][] matrix, int matrixBeginJ,
            int matrixEndJ, Integer rowIndex, int target) {

            int begin = matrixBeginJ;
            int end = matrixEndJ;
            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (matrix[rowIndex][mid] == target) {
                    return null;
                } else if (matrix[rowIndex][mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }
            return begin;
        }

        private Integer findFirstGreaterThanTargetInColumn(int[][] matrix, int matrixBeginI,
            int matrixEndI, Integer columnIndex, int target) {

            int begin = matrixBeginI;
            int end = matrixEndI;
            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (matrix[mid][columnIndex] == target) {
                    return null;
                } else if (matrix[mid][columnIndex] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }
            return begin;
        }

        private Integer findLastLessThanTargetInColumn(int[][] matrix, int matrixBeginI,
            int matrixEndI, int columnIndex, int target) {

            int begin = matrixBeginI;
            int end = matrixEndI;
            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (matrix[mid][columnIndex] == target) {
                    return null;
                } else if (matrix[mid][columnIndex] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }
            return begin - 1;
        }

        private Integer findLastLessThanTargetInRow(int[][] matrix, int matrixBeginJ,
            int matrixEndJ, int rowIndex, int target) {

            int begin = matrixBeginJ;
            int end = matrixEndJ;
            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (matrix[rowIndex][mid] == target) {
                    return null;
                } else if (matrix[rowIndex][mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }
            return begin - 1;
        }
    }
}
