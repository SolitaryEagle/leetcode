package com.leetcode.程序员面试宝典;

import java.util.Arrays;

/**
 * @author 覃国强
 * @date 2020-09-18 07:37
 */
public class 面试题_10_11_峰与谷 {


    static class Solution {

        public void wiggleSort(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            for (int i = 1; i < nums.length; ++i) {
                if (i % 2 == 0) {
                    if (nums[i] > nums[i - 1]) {
                        swap(nums, i, i - 1);
                    }
                } else {
                    if (nums[i] < nums[i - 1]) {
                        swap(nums, i, i - 1);
                    }
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
