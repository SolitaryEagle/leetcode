package com.leetcode.程序员面试宝典;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author 覃国强
 * @date 2020-09-18 07:25
 */
public class 面试题_10_10_数字流的秩 {


    static class StreamRank {

        private final Map<Integer, Integer> map = new HashMap<>();

        public StreamRank() {

        }

        public void track(int x) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }

        public int getRankOfNumber(int x) {
            int result = 0;
            for (Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() <= x) {
                    result += entry.getValue();
                }
            }
            return result;
        }
    }

}
