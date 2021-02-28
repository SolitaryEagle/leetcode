package com.leetcode.weekly.competition.no230th;

import java.util.Arrays;

/**
 * @author 覃国强
 * @date 2021-02-28 11:14
 */
public class A03_通过最少操作次数使数组的和相等 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums1 = {3,3,2,4,2,6,2};
    int[] nums2 = {6,2,6,6,1,1,4,6,4,6,2,5,4,2,1};
    int result = solution.minOperations(nums1, nums2);
    System.out.println(result);

  }

  static
  class Solution {
    public int minOperations(int[] nums1, int[] nums2) {

      int lenMin = Math.min(nums1.length, nums2.length);
      int lenMax = Math.max(nums1.length, nums2.length);

      if (lenMin * 6 < lenMax) {
        return -1;
      }

      int sum1 = sumArr(nums1);
      int sum2 = sumArr(nums2);

      if (sum1 == sum2) {
        return 0;
      }

      Arrays.sort(nums1);
      Arrays.sort(nums2);

      int diff = Math.abs(sum1 - sum2);

      int result = 0;

      if (sum1 < sum2) {
        // nums1 变大， nums2 变小
        for (int i = 0, j = nums2.length - 1; i < nums1.length || j >= 0; ) {
          int profit1 = i < nums1.length ? 6 - nums1[i] : 0;
          int profit2 = j >= 0 ? nums2[j] - 1 : 0;

          if (profit1 > profit2) {
            // nums1 变大
            ++i;
            ++result;
            if (diff > profit1) {
              diff -= profit1;
            } else {
              return result;
            }
          } else {
            // nums2 变小
            --j;
            ++result;
            if (diff > profit2) {
              diff -= profit2;
            } else {
              return result;
            }
          }
        }
      } else {
        // nums1 变小， nums2 变大
        for (int i = nums1.length - 1, j = 0; i >= 0 || j < nums2.length; ) {
          int profit1 = i >= 0 ? nums1[i] - 1 : 0;
          int profit2 = j < nums2.length ? 6 - nums2[j] : 0;

          if (profit1 > profit2) {
            // nums1 变小
            --i;
            ++result;
            if (diff > profit1) {
              diff -= profit1;
            } else {
              return result;
            }
          } else {
            // nums2 变大
            ++j;
            ++result;
            if (diff > profit2) {
              diff -= profit2;
            } else {
              return result;
            }
          }
        }
      }
      return -1;
    }

    private int sumArr(int[] nums) {
      int result = 0;
      for (int num : nums) {
        result += num;
      }
      return result;
    }
  }

}
