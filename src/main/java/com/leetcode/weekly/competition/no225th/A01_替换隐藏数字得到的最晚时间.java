package com.leetcode.weekly.competition.no225th;

/**
 * @author 覃国强
 * @date 2021-01-24 10:30
 */
public class A01_替换隐藏数字得到的最晚时间 {

  public static void main(String[] args) {
    Solution solution = new Solution();

    String time1 = "2?:?0";
    String time2 = "0?:3?";
    String time3 = "1?:22";
    String time4 = "??:??";
    String time5 = "?4:03";

    System.out.println(solution.maximumTime(time1));
    System.out.println(solution.maximumTime(time2));
    System.out.println(solution.maximumTime(time3));
    System.out.println(solution.maximumTime(time4));
    System.out.println(solution.maximumTime(time5));

  }

  static
  class Solution {
    public String maximumTime(String time) {

      char[] chars = time.toCharArray();
      if (chars[0] == '?') {
        if (chars[1] == '?' || chars[1] < '4') {
          chars[0] = '2';
        } else {
          chars[0] = '1';
        }
      }

      if (chars[1] == '?') {
        if (chars[0] < '2') {
          chars[1] = '9';
        } else {
          chars[1] = '3';
        }
      }

      if (chars[3] == '?') {
        chars[3] = '5';
      }

      if (chars[4] == '?') {
        chars[4] = '9';
      }

      return new String(chars);

    }
  }

}
