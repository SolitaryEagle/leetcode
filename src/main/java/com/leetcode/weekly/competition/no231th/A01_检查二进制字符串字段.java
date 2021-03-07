package com.leetcode.weekly.competition.no231th;

/**
 * @author 覃国强
 * @date 2021-03-07 11:00
 */
public class A01_检查二进制字符串字段 {

  static
  class Solution {
    public boolean checkOnesSegment(String s) {

      char[] chars = s.toCharArray();

      for (int i = 0; i < chars.length; ++i) {
        if (chars[i] == '1') {
          int j = i + 1;
          for (; j < chars.length; ++j) {
            if (chars[j] != '1') {
              break;
            }
          }
          for (; j < chars.length; ++j) {
            if (chars[j] == '1') {
              return false;
            }
          }
        }
      }
      return true;
    }
  }


}
