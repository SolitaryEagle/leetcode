package com.leetcode.程序员面试宝典;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author 覃国强
 * @date 2020-09-03 08:17
 */
public class 面试题_08_02_迷路的机器人 {


    static class Solution {

        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {

            Map<Coordinate, List<Coordinate>> pathMap = new HashMap<>();

            List<Coordinate> path = new ArrayList<>();
            path.add(new Coordinate(0, 0));
            pathMap.put(new Coordinate(0, 0), path);

            // 处理第一行
            for (int j = 1; j < obstacleGrid[0].length; ++j) {
                if (obstacleGrid[0][j] == 1) {
                    break;
                }
                List<Coordinate> prePath = pathMap.get(new Coordinate(0, j - 1));
                List<Coordinate> curPath = new ArrayList<>(prePath);
                curPath.add(new Coordinate(0, j));
                pathMap.put(new Coordinate(0, j), curPath);
            }

            // 处理第一列
            for (int i = 1; i < obstacleGrid.length; ++i) {
                if (obstacleGrid[i][0] == 1) {
                    break;
                }
                List<Coordinate> prePath = pathMap.get(new Coordinate(i - 1, 0));
                List<Coordinate> curPath = new ArrayList<>(prePath);
                curPath.add(new Coordinate(i, 0));
                pathMap.put(new Coordinate(i, 0), curPath);
            }

            for (int i = 1; i < obstacleGrid.length; ++i) {
                for (int j = 1; j < obstacleGrid[i].length; ++j) {
                    if (obstacleGrid[i][j] == 1 ||
                        (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] == 1)) {
                        continue;
                    }
                    List<Coordinate> prePath;
                    if (obstacleGrid[i][j - 1] != 1) {
                        prePath = pathMap.get(new Coordinate(i, j - 1));
                    } else {
                        prePath = pathMap.get(new Coordinate(i - 1, j));
                    }
                    List<Coordinate> curPath = new ArrayList<>(prePath);
                    curPath.add(new Coordinate(i, j));
                    pathMap.put(new Coordinate(i, j), curPath);
                }
            }

            List<Coordinate> coordinates = pathMap
                .get(new Coordinate(obstacleGrid.length - 1, obstacleGrid[0].length - 1));

            if (coordinates == null || coordinates.isEmpty()) {
                return new ArrayList<>();
            }

            List<List<Integer>> res = new ArrayList<>();
            for (Coordinate coordinate : coordinates) {
                List<Integer> list = new ArrayList<>();
                list.add(coordinate.x);
                list.add(coordinate.y);
                res.add(list);
            }

            return res;
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
