package com.leetcode.weekly.competition.no231th;

/**
 * @author 覃国强
 * @date 2021-03-07 11:07
 */
public class A02_构成特定和需要添加的最少元素 {


  static
  class Solution {
    public int minElements(int[] nums, int limit, int goal) {
      long sum = sumArr(nums);
      if (sum == goal) {
        return 0;
      }
      long diff = Math.abs(sum - goal);
      return (int) (diff / limit + (diff % limit == 0 ? 0 : 1));
    }

    private long sumArr(int[] nums) {
      long result = 0;
      for (int num : nums) {
        result += num;
      }
      return result;
    }

  }

}
