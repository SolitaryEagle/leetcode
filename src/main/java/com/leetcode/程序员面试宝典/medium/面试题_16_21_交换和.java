package com.leetcode.程序员面试宝典.medium;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author 覃国强
 * @date 2021-03-03 12:59
 */
public class 面试题_16_21_交换和 {

  public static void main(String[] args) throws FileNotFoundException {

    File file = new File("/home/eagle/work/eagle/github/leetcode/src/main/resources/array1");
    Scanner scanner = new Scanner(file);

    List<Integer> list1 = new ArrayList<>();

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String trimLine = line.trim();
      String[] split = trimLine.split(", *");
      for (String num : split) {
        try {
          int parseInt = Integer.parseInt(num);
          list1.add(parseInt);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    }


    File file2 = new File("/home/eagle/work/eagle/github/leetcode/src/main/resources/array2");
    Scanner scanner2 = new Scanner(file2);

    List<Integer> list2 = new ArrayList<>();

    while (scanner2.hasNextLine()) {
      String line = scanner2.nextLine();
      String trimLine = line.trim();
      String[] split = trimLine.split(", *");
      for (String num : split) {
        try {
          int parseInt = Integer.parseInt(num);
          list2.add(parseInt);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    }


    System.out.println(list1);
    System.out.println(list2);


    Solution solution = new Solution();
    int[] array1 = new int[list1.size()];
    for (int i = 0; i < list1.size(); ++i) {
      array1[i] = list1.get(i);
    }
    int[] array2 = new int[list2.size()];
    for (int i = 0; i < list2.size(); ++i) {
      array2[i] = list2.get(i);
    }
    int[] swapValues = solution.findSwapValues(array1, array2);
    System.out.println(Arrays.toString(swapValues));
  }

  static
  class Solution {

    public int[] findSwapValues(int[] array1, int[] array2) {

      if (array1 == null || array1.length == 0 || array2 == null || array2.length == 0) {
        return new int[0];
      }

      int sum1 = sumArr(array1);
      int sum2 = sumArr(array2);

      int[] maxArr;
      int[] minArr;
      int maxSum;
      int minSum;
      if (sum1 > sum2) {
        maxArr = array1;
        minArr = array2;
        maxSum = sum1;
        minSum = sum2;
      } else {
        maxArr = array2;
        minArr = array1;
        maxSum = sum2;
        minSum = sum1;
      }

      int diff = maxSum - minSum;
      int maxElement = maxElementInArr(maxArr);
      int minElement = minElementInArr(minArr);
      if ((maxElement - minElement) * 2 < diff) {
        return new int[0];
      }

      for (int i = 0; i < maxArr.length; ++i) {
        for (int j = 0; j < minArr.length; ++j) {
          if (maxArr[i] > minArr[j] && (maxArr[i] - minArr[j]) * 2 == diff) {
            if (sum1 > sum2) {
              return new int[]{maxArr[i], minArr[j]};
            } else {
              return new int[]{minArr[j], maxArr[i]};
            }
          }
        }
      }

      return new int[0];
    }

    private int minElementInArr(int[] minArr) {
      int result = minArr[0];
      for (int i = 1; i < minArr.length; ++i) {
        if (minArr[i] < result) {
          result = minArr[i];
        }
      }
      return result;
    }

    private int maxElementInArr(int[] maxArr) {
      int result = maxArr[0];
      for (int i = 1; i < maxArr.length; ++i) {
        if (maxArr[i] > result) {
          result = maxArr[i];
        }
      }
      return result;
    }

    private int sumArr(int[] arr) {
      int result = 0;
      for (int num : arr) {
        result += num;
      }
      return result;
    }
  }


}
