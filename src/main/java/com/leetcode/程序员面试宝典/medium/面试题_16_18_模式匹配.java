package com.leetcode.程序员面试宝典.medium;

/**
 * @author 覃国强
 * @date 2021-02-25 13:11
 */
public class 面试题_16_18_模式匹配 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String pattern = "a", value = "zqvamqvuuvvazv";
    boolean result = solution.patternMatching(pattern, value);
    System.out.println(result);
  }

  static
  class Solution {

    public boolean patternMatching(String pattern, String value) {
      if (isEmpty(pattern)) {
        return isEmpty(value);
      }

      char[] patternChars = pattern.toCharArray();
      int aCount = 0;
      int bCount = 0;
      for (char ch : patternChars) {
        if (ch == 'a') {
          ++aCount;
        } else {
          ++bCount;
        }
      }

      if (isEmpty(value)) {
        return aCount == 0 || bCount == 0;
      }

      if (aCount == 0 || bCount == 0) {
        if (value.length() % pattern.length() != 0) {
          return false;
        }
        int aLen = 0;
        if (aCount != 0) {
          aLen = value.length() / pattern.length();
        }
        int bLen = 0;
        if (bCount != 0) {
          bLen = value.length() / pattern.length();
        }
        return match(patternChars, value, aLen, bLen);
      }

      // aLen = 0
      if (value.length() % bCount == 0) {
        int aLen = 0;
        int bLen = value.length() / bCount;
        boolean match = match(patternChars, value, aLen, bLen);
        if (match) {
          return true;
        }
      }

      // bLen = 0;
      if (value.length() % aCount == 0) {
        int aLen = value.length() / aCount;
        int bLen = 0;
        boolean match = match(patternChars, value, aLen, bLen);
        if (match) {
          return true;
        }
      }

      int aLenMax;
      if (value.length() % aCount == 0) {
        aLenMax = value.length() / aCount - 1;
      } else {
        aLenMax = value.length() / aCount;
      }

      int bLenMax;
      if (value.length() % bCount == 0) {
        bLenMax = value.length() / bCount - 1;
      } else {
        bLenMax = value.length() / bCount;
      }

      if (aLenMax < bLenMax) {
        for (int aLen = 1; aLen <= aLenMax; ++aLen) {
          if ((value.length() - aCount * aLen) % bCount == 0) {
            int bLen = (value.length() - aCount * aLen) / bCount;
            boolean match = match(patternChars, value, aLen, bLen);
            if (match) {
              return true;
            }
          }
        }
      } else {
        for (int bLen = 1; bLen <= bLenMax; ++bLen) {
          if ((value.length() - bCount * bLen) % aCount == 0) {
            int aLen = (value.length() - bCount * bLen) / aCount;
            boolean match = match(patternChars, value, aLen, bLen);
            if (match) {
              return true;
            }
          }
        }
      }
      return false;
    }

    private boolean match(char[] patternChars, String value, int aLen, int bLen) {
      int i = 0;
      int j = 0;
      String aBase = "";
      String bBase = "";
      boolean flag = true;
      for (; i < patternChars.length; ++i) {
        if (patternChars[i] == 'a' && aLen != 0) {
          String test = value.substring(j, j + aLen);
          j += aLen;
          if (isEmpty(aBase)) {
            aBase = test;
          } else if (!aBase.equals(test)) {
            flag = false;
            break;
          }
        } else if (patternChars[i] == 'b' && bLen != 0){
          String test = value.substring(j, j + bLen);
          j += bLen;
          if (isEmpty(bBase)) {
            bBase = test;
          } else if (!bBase.equals(test)) {
            flag = false;
            break;
          }
        }
      }
      return flag;
    }

    private boolean isEmpty(String str) {
      return str == null || str.length() == 0;
    }

  }


}
