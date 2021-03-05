package com.leetcode.程序员面试宝典.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 覃国强
 * @date 2021-03-05 12:36
 */
public class 面试题_16_24_数对和 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {5,6,5,6};
    int target = 11;
    List<List<Integer>> lists = solution.pairSums(nums, target);
    System.out.println(lists);
  }

  // 双指针
  static
  class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
      Arrays.sort(nums);
      List<List<Integer>> result = new ArrayList<>();
      int left = 0;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum == target) {
          result.add(Arrays.asList(nums[left], nums[right]));
          ++left;
          --right;
        } else if (sum > target) {
          --right;
        } else {
          ++left;
        }
      }
      return result;
    }
  }

  static
  class Solution_1 {

    public List<List<Integer>> pairSums(int[] nums, int target) {

      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
        map.merge(num, 1, Integer::sum);
      }

      List<List<Integer>> result = new ArrayList<>();

      for (int num : nums) {
        int diff = target - num;

        // num 与 diff 不同，并且 map 中都有
        boolean diffAndAllIn = num != diff && map.containsKey(num) && map.containsKey(diff);

        // num 与 diff 相同，map 中有至少两个
        boolean equalAndLeastTwo = num == diff && map.containsKey(num) && map.get(num) > 1;

        if (diffAndAllIn || equalAndLeastTwo) {
          List<Integer> tmp = new ArrayList<>();
          tmp.add(num);
          tmp.add(diff);
          result.add(tmp);
          map.compute(num, (key, value) -> value == 1 ? null : value - 1);
          map.compute(diff, (key, value) -> value == 1 ? null : value - 1);
        }
      }
      return result;
    }
  }

}
