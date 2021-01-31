package com.leetcode.weekly.competition.no226th;

/**
 * @author 覃国强
 * @date 2021-01-31 11:33
 */
public class A03_你能在你最喜欢的那天吃到你最喜欢的糖果吗 {

  static
  class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {

      long[] candiesCountSum = new long[candiesCount.length];
      candiesCountSum[0] = candiesCount[0];
      for (int i = 1; i < candiesCount.length; ++i) {
        candiesCountSum[i] = candiesCountSum[i - 1] + candiesCount[i];
      }

      boolean[] result = new boolean[queries.length];
      int resultIndex = 0;

      for (int i = 0; i < queries.length; ++i) {
        int[] query = queries[i];
        int favoriteType = query[0];
        long favoriteDay = query[1];
        long dailyCap = query[2];

        long notFavoriteTypeSum = favoriteType == 0 ? 0 : candiesCountSum[favoriteType - 1];

        if (notFavoriteTypeSum > favoriteDay &&
            notFavoriteTypeSum <= favoriteDay * dailyCap) {
          result[resultIndex++] = true;
          continue;
        }

        if (notFavoriteTypeSum < favoriteDay &&
            candiesCountSum[favoriteType] >= favoriteDay + 1) {
          result[resultIndex++] = true;
          continue;
        }

        if (notFavoriteTypeSum > favoriteDay * dailyCap) {
          long left = notFavoriteTypeSum -  favoriteDay * dailyCap;
          if (left < dailyCap) {
            result[resultIndex++] = true;
            continue;
          }
        }
        result[resultIndex++] = false;
      }
      return result;
    }
  }

}
