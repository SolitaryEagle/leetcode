package com.leetcode.weekly.competition.no230th;

/**
 * @author 覃国强
 * @date 2021-02-28 10:46
 */
public class A02_最接近目标价格的甜点成本 {

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] baseCosts = {10};
    int[] toppingCosts = {1};
    int target = 1;
    int closestCost = solution.closestCost(baseCosts, toppingCosts, target);
    System.out.println(closestCost);

  }

  static
  class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {

      int minAbs = Integer.MAX_VALUE;
      int result = 0;
      for (int i = 0; i < baseCosts.length; ++i) {
        int closest = closest(toppingCosts, 0, target - baseCosts[i]);
        int abs = Math.abs(target - (closest + baseCosts[i]));
        if (abs < minAbs) {
          minAbs = abs;
          result = closest + baseCosts[i];
        }
      }

      return result;
    }

    private int closest(int[] toppingCosts, int index, int target) {

      if (index == toppingCosts.length || target <= 0) {
        return 0;
      }

      // 0 个 index
      int closest1 = closest(toppingCosts, index + 1, target);

      // 1 个 index
      int closest2 = closest(toppingCosts, index + 1, target - toppingCosts[index]);

      // 2 个 index
      int closest3 = closest(toppingCosts, index + 1, target - 2 * toppingCosts[index]);

      int num1 = closest1;
      int num2 = closest2 + toppingCosts[index];
      int num3 = closest3 + 2 * toppingCosts[index];

      int abs1 = Math.abs(target - num1);
      int abs2 = Math.abs(target - num2);
      int abs3 = Math.abs(target - num3);

      int minAbs = Math.min(abs1, Math.min(abs2, abs3));

      if (minAbs == abs1) {
        return num1;
      } else if (minAbs == abs2) {
        return num2;
      } else {
        return num3;
      }
    }
  }

}
