package com.leetcode.程序员面试宝典;

import java.util.Arrays;

/**
 * @author 覃国强
 * @date 2021-02-24 13:06
 */
public class 面试题_16_16_部分排序 {

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] array = {1, 2};
    int[] result = solution.subSort(array);

    System.out.println(Arrays.toString(result));
  }

  static
  class Solution {

    public int[] subSort(int[] array) {

      int[] result = {-1, -1};

      if (array == null || array.length < 2) {
        return result;
      }

      // 从小到大排序

      //        有序               无序                有序
      // |------left------|------middle------|-------right------|

      int leftArrRightBound = 0;
      for (int i = 1; i < array.length; ++i) {
        if (array[i - 1] < array[i]) {
          leftArrRightBound = i;
        } else {
          break;
        }
      }

      // 默认有序
      if (leftArrRightBound == array.length - 1) {
        return result;
      }

      int rightArrLeftBound = array.length - 1;
      for (int i = array.length - 2; i >= 0; --i) {
        if (array[i + 1] > array[i]) {
          rightArrLeftBound = i;
        }
      }

      int middleMin = Integer.MAX_VALUE;
      int middleMax = Integer.MIN_VALUE;
      for (int i = leftArrRightBound + 1; i < rightArrLeftBound; ++i) {
        if (array[i] < middleMin) {
          middleMin = array[i];
        }
        if (array[i] > middleMax) {
          middleMax = array[i];
        }
      }

      // 使用 middleMin 判断真实的右边界








      int start1 = 0;
      int end1 = array.length - 1;
      while (start1 < end1 && headIsMin(array, start1, end1)) {
        ++start1;
      }

      if (start1 == end1) {
        return result;
      }

      while (start1 < end1 && tailIsMax(array, start1, end1)) {
        --end1;
      }

      // 从大到小排序
      int start2 = 0;
      int end2 = array.length - 1;
      while (start2 < end2 && headIsMax(array, start2, end2)) {
        ++start2;
      }
      if (start2 == end2) {
        return result;
      }
      while (start2 < end2 && tailIsMin(array, start2, end2)) {
        --end2;
      }

      if (end1 - start1 < end2 - start2) {
        result[0] = start1;
        result[1] = end1;
      } else {
        result[0] = start2;
        result[1] = end2;
      }
      return result;
    }

    private boolean headIsMin(int[] array, int start, int end) {
      for (int i = start + 1; i <= end; ++i) {
        if (array[start] > array[i]) {
          return false;
        }
      }
      return true;
    }

    private boolean tailIsMax(int[] array, int start, int end) {
      for (int i = start; i < end; ++i) {
        if (array[end] < array[i]) {
          return false;
        }
      }
      return true;
    }

    private boolean headIsMax(int[] array, int start, int end) {
      for (int i = start + 1; i <= end; ++i) {
        if (array[start] < array[i]) {
          return false;
        }
      }
      return true;
    }

    private boolean tailIsMin(int[] array, int start, int end) {
      for (int i = start; i < end; ++i) {
        if (array[end] > array[i]) {
          return false;
        }
      }
      return true;
    }

  }
}
