package com.leetcode.程序员面试宝典;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 覃国强
 * @date 2021-03-01 12:45
 */
public class 面试题_16_19_水域大小 {

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] land = {
        {0, 2, 1, 0},
        {0, 1, 0, 1},
        {1, 1, 0, 1},
        {0, 1, 0, 1}
    };

    int[] result = solution.pondSizes(land);

    System.out.println(Arrays.toString(result));


  }


  static
  class Solution {

    private static int[] directionI = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] directionJ = {-1, 0, 1, -1, 1, -1, 0, 1};

    public int[] pondSizes(int[][] land) {

      if (land == null || land.length == 0) {
        return new int[0];
      }

      boolean[][] flag = new boolean[land.length][land[0].length];

      List<Integer> result = new ArrayList<>();

      for (int i = 0; i < land.length; ++i) {
        for (int j = 0; j < land[i].length; ++j) {
          if (land[i][j] == 0 && !flag[i][j]) {
            int pondSize = pondSizes(land, i, j, flag);
            result.add(pondSize);
          }
        }
      }

      Collections.sort(result);
      int[] res = new int[result.size()];
      for (int i = 0; i < result.size(); ++i) {
        res[i] = result.get(i);
      }

      return res;
    }

    private int pondSizes(int[][] land, int i, int j, boolean[][] flag) {

      if (i < 0 || i >= land.length) {
        return 0;
      }
      if (j < 0 || j >= land[i].length) {
        return 0;
      }
      if (flag[i][j]) {
        return 0;
      }
      flag[i][j] = true;
      if (land[i][j] != 0) {
        return 0;
      }

      int result = 1;
      for (int index = 0; index < directionI.length; ++index) {
        result += pondSizes(land, i + directionI[index], j + directionJ[index], flag);
      }

      return result;
    }
  }

}
