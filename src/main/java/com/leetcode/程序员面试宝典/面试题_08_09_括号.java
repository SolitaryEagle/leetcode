package com.leetcode.程序员面试宝典;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 覃国强
 * @date 2020-09-09 07:56
 */
public class 面试题_08_09_括号 {


    static class Solution {

        public List<String> generateParenthesis(int n) {

            List<String> result = new ArrayList<>();

            if (n == 0) {
                return result;
            }

            List<List<String>> dp = new ArrayList<>();
            List<String> dp0 = new ArrayList<>();
            dp0.add("");
            dp.add(dp0);

            for (int i = 1; i <= n; ++i) {
                List<String> cur = new ArrayList<>();
                for (int j = 0; j < i; ++j) {
                    List<String> mays = dp.get(j);
                    List<String> rests = dp.get(i - 1 - j);
                    for (String may : mays) {
                        for (String rest : rests) {
                            cur.add("(" + may + ")" + rest);
                        }
                    }
                }
                dp.add(cur);
            }
            return dp.get(n);
        }
    }
}
