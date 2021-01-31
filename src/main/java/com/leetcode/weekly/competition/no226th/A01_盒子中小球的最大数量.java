package com.leetcode.weekly.competition.no226th;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 覃国强
 * @date 2021-01-31 10:31
 */
public class A01_盒子中小球的最大数量 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.countBalls(1, 10));
  }

  static
  class Solution {
    public int countBalls(int lowLimit, int highLimit) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = lowLimit; i <= highLimit; ++i) {
        int boxNum = getBoxNum(i);
        Integer oldCount = map.getOrDefault(boxNum, 0);
        map.put(boxNum, oldCount + 1);
      }
      int result = -1;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() > result) {
          result = entry.getValue();
        }
      }
      return result;
    }

    private int getBoxNum(int ballNum) {
      int result = 0;
      while (ballNum > 0) {
        result += ballNum % 10;
        ballNum /= 10;
      }
      return result;
    }
  }

}
