package com.leetcode.程序员面试宝典.medium;

/**
 * @author 覃国强
 * @date 2020-09-14 07:48
 */
public class 面试题_10_03_搜索旋转数组 {

    public static void main(String[] args) {

        Solution solution = new Solution();


        int[] arr = {10, 12, 13, 15, 15, 15, 17, 19, 24, 26, 30, 30, 33, 35, 35, 36, 37, 39, 39, 41, 45, 48, 49, 49, 50, 52, 54, 55, 57, 62, 66, 70, 73, 85, 85, 87, 89, 93, 96, 96, 99, 99, -98, -91, -88, -87, -84, -82, -81, -81, -79, -78, -77, -75, -73, -69, -67, -64, -64, -61, -58, -57, -55, -55, -52, -49, -48, -40, -36, -35, -31, -22, -20, -20, -20, -20, -18, -15, -14, -14, -13, -5, -5, -4, -4, -3, -2, -1, 0, 2, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9};

        System.out.println(solution.search(arr, 165310062));
    }


    static class Solution {

        public int search(int[] arr, int target) {

            if (arr == null || arr.length == 0) {
                return -1;
            }

            if (arr.length == 1) {
                return arr[0] == target ? 0 : -1;
            }

            return specialBinarySearch(arr, target);
        }

        private int normalBinarySearch(int[] arr, int begin, int end, int target) {

            while (begin <= end) {
                if (arr[begin] == target) {
                    return begin;
                }
                int mid = (begin + end) / 2;
                if (arr[mid] < target) {
                    begin = mid + 1;
                } else if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    end = mid;
                }
            }

            return -1;
        }

        private int specialBinarySearch(int[] arr, int target) {

            int begin = 0;
            int end = arr.length - 1;

            while (begin <= end) {
                if (arr[begin] < arr[end]) {
                    return normalBinarySearch(arr, begin, end, target);
                }

                if (arr[begin] == target) {
                    return begin;
                }
                if (begin == end) {
                    return -1;
                }
                int mid = (begin + end) / 2;
                if (arr[begin] < arr[mid]) {
                    if (arr[begin] < target && target <= arr[mid]) {
                        end = mid;
                    } else {
                        begin = mid;
                    }
                } else if (arr[begin] > arr[mid]) {
                    if (arr[begin] < target || target <= arr[mid]) {
                        end = mid;
                    } else {
                        begin = mid;
                    }
                } else {
                    // 这里应该如何优化？
                    begin++;
                }
            }

            return -1;
        }

    }

}
