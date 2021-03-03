package com.leetcode.程序员面试宝典.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 覃国强
 * @date 2020-09-18 08:00
 */
public class 面试题_16_02_单词频率 {

    static class WordsFrequency {

        private final Map<String, Integer> map;

        public WordsFrequency(String[] book) {
            map = new HashMap<>(book.length);
            for (String str : book) {
                map.compute(str, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
            }
        }

        public int get(String word) {
            return map.getOrDefault(word, 0);
        }
    }


}
