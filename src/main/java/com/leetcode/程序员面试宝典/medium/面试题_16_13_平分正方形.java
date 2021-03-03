package com.leetcode.程序员面试宝典.medium;

import java.util.Arrays;

/**
 * @author 覃国强
 * @date 2020-11-14 16:41
 */
public class 面试题_16_13_平分正方形 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] square1 = {249,-199,5};
    int[] square2 = {-1,136,76};

    double[] result = solution.cutSquares(square1, square2);
    System.out.println(Arrays.toString(result));
  }

  static class Solution {

    public double[] cutSquares(int[] square1, int[] square2) {

      // 构建两个正方形对象
      Square squareObj1 = new Square(square1);
      Square squareObj2 = new Square(square2);

      // 情况一：中心点 x 坐标一样
      if (squareObj1.centralPoint.x == squareObj2.centralPoint.x) {
        double[] result = new double[4];
        result[0] = squareObj1.centralPoint.x;
        result[1] = Math.min(squareObj1.leftDown.y, squareObj2.leftDown.y);
        result[2] = squareObj1.centralPoint.x;
        result[3] = Math.max(squareObj1.leftUp.y, squareObj2.leftUp.y);
        return result;
      }

      // 求两个中心点形成的斜率
      double k = (squareObj1.centralPoint.y - squareObj2.centralPoint.y) /
          (squareObj1.centralPoint.x - squareObj2.centralPoint.x);

      double absK = Math.abs(k);

      if (absK <= 1) {
        double[] result = new double[4];
        if (squareObj1.leftDown.x < squareObj2.leftDown.x) {
          result[0] = squareObj1.leftDown.x;
          result[1] = k * (squareObj1.leftDown.x - squareObj1.centralPoint.x) + squareObj1.centralPoint.y;
        } else {
          result[0] = squareObj2.leftDown.x;
          result[1] = k * (squareObj2.leftDown.x - squareObj1.centralPoint.x) + squareObj1.centralPoint.y;
        }

        if (squareObj1.rightDown.x > squareObj2.rightDown.x) {
          result[2] = squareObj1.rightDown.x;
          result[3] = k * (squareObj1.rightDown.x - squareObj1.centralPoint.x) + squareObj1.centralPoint.y;
        } else {
          result[2] = squareObj2.rightDown.x;
          result[3] = k * (squareObj2.rightDown.x - squareObj1.centralPoint.x) + squareObj1.centralPoint.y;
        }
        return result;
      } else {
        double[] result = new double[4];
        double tmpX1 = (squareObj1.leftDown.y - squareObj1.centralPoint.y) / k + squareObj1.centralPoint.x;
        double tmpX2 = (squareObj2.leftDown.y - squareObj1.centralPoint.y) / k + squareObj1.centralPoint.x;
        double tmpX3 = (squareObj1.leftUp.y - squareObj1.centralPoint.y) / k + squareObj1.centralPoint.x;
        double tmpX4 = (squareObj2.leftUp.y - squareObj1.centralPoint.y) / k + squareObj1.centralPoint.x;

        double minX = Math.min(tmpX1, Math.min(tmpX2, Math.min(tmpX3, tmpX4)));
        double maxX = Math.max(tmpX1, Math.max(tmpX2, Math.max(tmpX3, tmpX4)));

        if (minX == tmpX1) {
          result[0] = tmpX1;
          result[1] = squareObj1.leftDown.y;
        } else if (minX == tmpX2) {
          result[0] = tmpX2;
          result[1] = squareObj2.leftDown.y;
        } else if (minX == tmpX3) {
          result[0] = tmpX3;
          result[1] = squareObj1.leftUp.y;
        } else {
          result[0] = tmpX4;
          result[1] = squareObj2.leftUp.y;
        }

        if (maxX == tmpX1) {
          result[2] = tmpX1;
          result[3] = squareObj1.leftDown.y;
        } else if (maxX == tmpX2) {
          result[2] = tmpX2;
          result[3] = squareObj2.leftDown.y;
        } else if (maxX == tmpX3) {
          result[2] = tmpX3;
          result[3] = squareObj1.leftUp.y;
        } else {
          result[2] = tmpX4;
          result[3] = squareObj2.leftUp.y;
        }
        return result;
      }
    }

    static class Square {
      Coordinate leftDown;
      Coordinate leftUp;
      Coordinate rightDown;
      Coordinate rightUp;
      int edge;
      Coordinate centralPoint;

      Square(int[] data) {
        this.edge = data[2];
        this.leftDown = new Coordinate(data[0], data[1]);
        this.leftUp = new Coordinate(this.leftDown.x, this.leftDown.y + this.edge);
        this.rightDown = new Coordinate(this.leftDown.x + this.edge, this.leftDown.y);
        this.rightUp = new Coordinate(this.leftDown.x + this.edge, this.leftDown.y + this.edge);
        this.centralPoint = new Coordinate(data[0] + data[2] / 2.0, data[1] + data[2] / 2.0);
      }
    }

    static class Coordinate {
      double x;
      double y;

      Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
      }
    }
  }

}
