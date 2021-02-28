package com.leetcode.weekly.competition.no230th;

import java.util.List;

/**
 * @author 覃国强
 * @date 2021-02-28 10:36
 */
public class A01_统计匹配检索规则的物品数量 {


  static
  class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

      if (items == null || items.size() == 0) {
        return 0;
      }

      int result = 0;
      for (List<String> item : items) {
        if (item == null || item.size() != 3) {
          continue;
        }
        if ("type".equals(ruleKey) && item.get(0).equals(ruleValue)) {
          ++result;
        } else if ("color".equals(ruleKey) && item.get(1).equals(ruleValue)) {
          ++result;
        } else if ("name".equals(ruleKey) && item.get(2).equals(ruleValue)) {
          ++result;
        }
      }

      return result;
    }
  }


}
