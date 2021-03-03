package com.leetcode.程序员面试宝典.medium;

/**
 * @author 覃国强
 * @date 2020-09-18 07:52
 */
public class 面试题_16_01_交换数字 {

    static class Solution {

        public int[] swapNumbers(int[] numbers) {
            numbers[0] = numbers[0] ^ numbers[1];
            numbers[1] = numbers[0] ^ numbers[1];
            numbers[0] = numbers[0] ^ numbers[1];
            return numbers;
        }
    }
}
