package com.leetcode.程序员面试宝典;

/**
 * @author 覃国强
 * @date 2020-09-14 07:48
 */
public class 面试题_10_03_搜索旋转数组 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        System.out.println(solution.findMinIndex(arr));

    }


    static class Solution {

        public int search(int[] arr, int target) {

            if (arr == null || arr.length == 0) {
                return -1;
            }

            int minIndex = findMinIndex(arr);

            return 0;
        }

        private int search(int[] arr, int begin, int end, int target) {

            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (arr[mid] == target) {
                    if (mid > 0 && arr[mid - 1] == arr[mid]) {
                        end = mid - 1;
                    } else {
                        return mid;
                    }
                } else if (arr[mid] < arr[begin]) {
                    if (arr[mid] < target) {

                    }
                }
            }

            return 0;
        }

        private int findMinIndex(int[] arr) {
            if (arr.length == 1) {
                return 0;
            }

            if (arr[0] < arr[arr.length - 1]) {
                return 0;
            }

            if (arr[0] > arr[1]) {
                return 1;
            }

            if (arr[arr.length - 2] > arr[arr.length - 1]) {
                return arr.length - 1;
            }

            int begin = 1;
            int end = arr.length - 2;

            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
                    return mid;
                }
                if (arr[mid] < arr[end]) {
                    end = mid - 1;
                } else if (arr[mid] > arr[end]) {
                    begin = mid + 1;
                }
            }

            return 0;
        }
    }

}
