package com.leetcode.程序员面试宝典.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 覃国强
 * @date 2021-03-04 12:50
 */
public class 面试题_16_22_兰顿蚂蚁 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    List<String> strings = solution.printKMoves(100000);
    for (String str : strings) {
      System.out.println(str);
    }
  }

  static
  class Solution {

    public List<String> printKMoves(int K) {

      Set<Point> blackPoints = new HashSet<>();
      int x = 0;
      int y = 0;
      char dire = 'R';
      boolean isBlack;

      int minX = 0;
      int maxX = 0;
      int minY = 0;
      int maxY = 0;

      for (int i = 0; i < K; ++i) {
        Point point = new Point(x, y);
        isBlack = blackPoints.contains(point);
        if (isBlack) {
          // 黑色方格
          // 当前方格变白，从 blackPoints 中删除
          blackPoints.remove(point);
          switch (dire) {
            case 'L':
              dire = 'D';
              x = x + 1;
              break;
            case 'U':
              dire = 'L';
              y = y - 1;
              break;
            case 'R':
              dire = 'U';
              x = x - 1;
              break;
            case 'D':
              dire = 'R';
              y = y + 1;
              break;
            default:
              // 什么也不做
          }
        } else {
          // 白色方格
          // 当前方格变黑，加入 blackPoints 中
          blackPoints.add(point);
          switch (dire) {
            case 'L':
              dire = 'U';
              x = x - 1;
              break;
            case 'U':
              dire = 'R';
              y = y + 1;
              break;
            case 'R':
              dire = 'D';
              x = x + 1;
              break;
            case 'D':
              dire = 'L';
              y = y - 1;
              break;
            default:
              // 什么也不做
          }
        }

        minX = Math.min(x, minX);
        minY = Math.min(y, minY);
        maxX = Math.max(x, maxX);
        maxY = Math.max(y, maxY);
      }

      char[][] grid = new char[maxX - minX + 1][maxY - minY + 1];
      for (char[] row : grid) {
        Arrays.fill(row, '_');
      }
      for (Point point : blackPoints) {
        grid[point.x - minX][point.y - minY] = 'X';
      }
      grid[x - minX][y - minY] = dire;
      List<String> result = new ArrayList<>();
      for (char[] row : grid) {
        result.add(String.valueOf(row));
      }

      return result;
    }

    static class Point {

      int x;
      int y;

      Point(int x, int y) {
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
        Point point = (Point) o;
        return x == point.x && y == point.y;
      }

      @Override
      public int hashCode() {
        return 31 * x + y;
      }
    }

  }

}
