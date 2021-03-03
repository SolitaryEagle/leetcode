package com.leetcode.程序员面试宝典.medium;

import java.util.Arrays;

/**
 * @author 覃国强
 * @date 2021-02-24 12:30
 */
public class 面试题_16_14_最佳直线 {

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] points =

{{7992,-18313},{-10573,-31818},{8499,-11806},{-48723,31818},{-52831,-19716},{9037,-31558},{-25098,-15352},{2603,-32737},{-29648,0},{-19349,10382},{-58704,-6960},{30052,-20287},{19619,-2656},{-58704,-19478},{-19303,27902},{13531,6128},{-58704,-1486},{-33792,-29361},{-58704,-19201},{-58704,-4099},{-50629,2118},{-58704,6509},{-8027,-38938},{-58704,-24435},{-24278,-20995},{-592,24435},{-54425,52082},{-16394,-17262},{-36236,-21798},{-31024,-31850},{1561,-3228},{-16280,-20998},{27531,-31532},{-41059,-30190},{-34349,-31296},{-39446,-18587},{-2882,159},{-21897,-25637},{-33016,-32722},{-42239,-15914},{29077,-31210}}
    
    
    ;
    int[] result = solution.bestLine(points);

    System.out.println(Arrays.toString(result));

  }

  static
  class Solution {

    public int[] bestLine(int[][] points) {

      int[] result = new int[2];
      int maxCount = 0;

      for (int i = 0; i < points.length; ++i) {
        for (int j = i + 1; j < points.length; ++j) {
          int tmpCount = 2;
          for (int k = j + 1; k < points.length; ++k) {
            // 为避免精度问题，使用 乘法 代替 斜率
            if ((points[k][1] - points[i][1]) * (points[j][0] - points[i][0])
                == (points[j][1] - points[i][1]) * (points[k][0] - points[i][0])) {
              ++tmpCount;
            }
          }

          System.out.println("[" + i + ", " + j + "] --> " + tmpCount);

          if (tmpCount > maxCount) {
            maxCount = tmpCount;
            result[0] = i;
            result[1] = j;
          }
        }
      }
      return result;
    }
  }

}
