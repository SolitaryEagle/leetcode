package com.leetcode.weekly.competition.no224th;

/**
 * @author 覃国强
 * @date 2021-01-17 10:30
 */
public class A01_可以形成最大正方形的矩形数目 {

  public static void main(String[] args) {
    int[][] rectangles =  {{2,3},{3,7},{4,3},{3,7}};
    Solution solution = new Solution();
    System.out.println(solution.countGoodRectangles(rectangles));
  }

  static class Solution {
    public int countGoodRectangles(int[][] rectangles) {
      int maxLen = -1;
      int count = 0;
      for (int i = 0; i < rectangles.length; ++i) {
        int tmp = Math.min(rectangles[i][0], rectangles[i][1]);
        if (tmp == maxLen) {
          count++;
        } else if (tmp > maxLen) {
          maxLen = tmp;
          count = 1;
        }
      }
      return count;
    }
  }

}
