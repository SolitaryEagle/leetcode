package com.leetcode.weekly.competition.no224th;

/**
 * @author 覃国强
 * @date 2021-01-17 10:45
 */
public class A02_同积元组 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int result;

    int[] nums2 = {1, 2, 4, 5, 10};
    result = solution.tupleSameProduct(nums2);
    System.out.println(result);

    int[] nums3 = {2, 3, 4, 6, 8, 12};
    result = solution.tupleSameProduct(nums3);
    System.out.println(result);

  }

  // 超出时间限制

  static class Solution {

    public int tupleSameProduct(int[] nums) {
      int result = 0;
      for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          for (int k = j + 1; k < nums.length; k++) {
            for (int m = k + 1; m < nums.length; m++) {
              result += getResult(new int[] {nums[i], nums[j], nums[k], nums[m]});
            }
          }
        }
      }
      return result;
    }

    public int getResult(int[] nums) {
      int result = 0;
      if (nums[0] * nums[1] == nums[2] * nums[3]) {
        result += 8;
      }
      if (nums[0] * nums[2] == nums[1] * nums[3]) {
        result += 8;
      }
      if (nums[0] * nums[3] == nums[1] * nums[2]) {
        result += 8;
      }
      return result;
    }

  }

}
