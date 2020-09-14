package com.leetcode.程序员面试宝典;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 覃国强
 * @date 2020-09-14 07:23
 */
public class 面试题_10_02_变位词组 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution.groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(list);
        }

    }


    static class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }

            Map<String, List<String>> map = new HashMap<>(strs.length);

            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                List<String> list = map.get(key);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(str);
                map.put(key, list);
            }

            return new ArrayList<>(map.values());
        }
    }
}
