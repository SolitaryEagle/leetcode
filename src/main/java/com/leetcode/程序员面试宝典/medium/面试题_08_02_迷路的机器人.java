package com.leetcode.程序员面试宝典.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author 覃国强
 * @date 2020-09-03 08:17
 */
public class 面试题_08_02_迷路的机器人 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] obstacleGrid = {
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
            {1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1},
            {0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0}
        };

        List<List<Integer>> lists = solution.pathWithObstacles(obstacleGrid);
        System.out.println(lists);
        System.out.println("==============");

        int[][] test = solution.testPathWithObstacles(obstacleGrid);

        for (int i = 0; i < test.length; ++i) {
            for (int j = 0; j < test[i].length; ++j) {
                System.out.print(test[i][j]);
            }
            System.out.println();
        }


        System.out.println("==============");

        int[][] obstacleGrid2 = {
            {0}
        };
        lists = solution.pathWithObstacles(obstacleGrid2);
        System.out.println(lists);
        System.out.println("==============");

    }


    static class Solution {

        public int[][] testPathWithObstacles(int[][] obstacleGrid) {


            int[][] tmp = new int[obstacleGrid.length][obstacleGrid[0].length];

            if (obstacleGrid[0][0] == 1) {
                return tmp;
            }

            tmp[0][0] = 1;

            // 处理第一行
            for (int j = 1; j < obstacleGrid[0].length; ++j) {
                if (obstacleGrid[0][j] == 1) {
                    break;
                }
                tmp[0][j] = 1;
            }

            // 处理第一列
            for (int i = 1; i < obstacleGrid.length; ++i) {
                if (obstacleGrid[i][0] == 1) {
                    break;
                }
                tmp[i][0] = 1;
            }


            for (int i = 1; i < obstacleGrid.length; ++i) {
                for (int j = 1; j < obstacleGrid[i].length; ++j) {
                    if (obstacleGrid[i][j] == 1) {
                        continue;
                    }

                    if (tmp[i - 1][j] != 1 && tmp[i][j - 1] != 1) {
                        continue;
                    }

                    tmp[i][j] = 1;

                }
            }

            return tmp;

        }

        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid[0][0] == 1) {
                return new ArrayList<>();
            }

            if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
                List<List<Integer>> result = new ArrayList<>();
                List<Integer> list = new ArrayList<>();
                list.add(0);
                list.add(0);
                result.add(list);
                return result;
            }

            Coordinate[][] preCoors = new Coordinate[obstacleGrid.length][obstacleGrid[0].length];

            // 处理第一行
            for (int j = 1; j < obstacleGrid[0].length; ++j) {
                if (obstacleGrid[0][j] == 1) {
                    break;
                }
                preCoors[0][j] = new Coordinate(0, j - 1);
            }

            // 处理第一列
            for (int i = 1; i < obstacleGrid.length; ++i) {
                if (obstacleGrid[i][0] == 1) {
                    break;
                }
                preCoors[i][0] = new Coordinate(i - 1, 0);
            }

            for (int i = 1; i < obstacleGrid.length; ++i) {
                for (int j = 1; j < obstacleGrid[i].length; ++j) {

                    if (obstacleGrid[i][j] == 1) {
                        continue;
                    }

                    if (preCoors[i - 1][j] == null && preCoors[i][j - 1] == null) {
                        continue;
                    }

                    if (preCoors[i][j - 1] != null) {
                        preCoors[i][j] = new Coordinate(i, j - 1);
                    } else {
                        preCoors[i][j] = new Coordinate(i - 1, j);
                    }

                }
            }

            if (preCoors[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == null) {
                return new ArrayList<>();
            }

            LinkedList<List<Integer>> result = new LinkedList<>();
            List<Integer> last = new ArrayList<>();
            last.add(obstacleGrid.length - 1);
            last.add(obstacleGrid[0].length - 1);
            result.add(last);

            Coordinate curCoor = preCoors[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
            while (curCoor != null) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(curCoor.x);
                tmp.add(curCoor.y);
                result.addFirst(tmp);
                curCoor = preCoors[curCoor.x][curCoor.y];
            }
            return result;
        }
    }

    static class Coordinate {

        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
