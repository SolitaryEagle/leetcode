package com.leetcode.程序员面试宝典.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author 覃国强
 * @date 2020-09-04 08:20
 */
public class 面试题_08_04_幂集 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {1, 2, 3};

        List<List<Integer>> subsets = solution.subsets(nums);

        System.out.println(subsets);

    }

   static class Solution {
        public List<List<Integer>> subsets(int[] nums) {

            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }

            if (nums.length == 1) {
                List<List<Integer>> result = new ArrayList<>();
                result.add(new ArrayList<>());
                List<Integer> list = new ArrayList<>();
                list.add(nums[0]);
                result.add(list);
                return result;
            }

            Deque<List<Integer>> cur = new ArrayDeque<>();
            Deque<List<Integer>> next = new ArrayDeque<>();

            List<List<Integer>> indexes = new ArrayList<>();

            for (int i = 0; i < nums.length; ++i) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                cur.add(list);
            }

            while (!cur.isEmpty()) {
                while (!cur.isEmpty()) {
                    List<Integer> poll = cur.poll();
                    indexes.add(new ArrayList<>(poll));

                    for (int i = poll.get(poll.size() - 1) + 1; i < nums.length; ++i) {
                        List<Integer> list = new ArrayList<>(poll);
                        list.add(i);
                        next.add(list);
                    }
                }
                cur = next;
                next = new ArrayDeque<>();
            }

            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());

            for (List<Integer> index : indexes) {
                List<Integer> numList = new ArrayList<>();
                for (int i : index) {
                    numList.add(nums[i]);
                }
                result.add(numList);
            }
            return result;
        }
    }

}
