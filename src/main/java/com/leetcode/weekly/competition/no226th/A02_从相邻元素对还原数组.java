package com.leetcode.weekly.competition.no226th;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author 覃国强
 * @date 2021-01-31 10:41
 */
public class A02_从相邻元素对还原数组 {

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] adjacentPairs = {{4,-10},{-1,3},{4,-3},{-3,3}};

    int[] arr = solution.restoreArray(adjacentPairs);
    System.out.println(Arrays.toString(arr));


  }

  static
  class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {

      List<Deque<Integer>> list = new ArrayList<>();
      for (int[] adjacentPair : adjacentPairs) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(adjacentPair[0]);
        deque.addLast(adjacentPair[1]);
        list.add(deque);
      }

      while (list.size() > 1) {
        Deque<Integer> first = list.get(0);

        for (int i = 1; i < list.size(); ++i) {
          Deque<Integer> deque = list.get(i);

          if (first.peekFirst().equals(deque.peekFirst())) {

            first.pollFirst();
            while (!first.isEmpty()) {
              deque.addFirst(first.pollFirst());
            }

            break;

          } else if (first.peekFirst().equals(deque.peekLast())) {

            first.pollFirst();
            while (!first.isEmpty()) {
              deque.addLast(first.pollFirst());
            }

            break;

          } else if (first.peekLast().equals(deque.peekFirst())) {

            first.pollLast();
            while (!first.isEmpty()) {
              deque.addFirst(first.pollLast());
            }

            break;


          } else if (first.peekLast().equals(deque.peekLast())) {

            first.pollLast();
            while (!first.isEmpty()) {
              deque.addLast(first.pollLast());
            }

            break;

          }
        }

        list.remove(0);

      }

      Deque<Integer> deque = list.get(0);
      int[] result = new int[deque.size()];
      int i = 0;
      while (!deque.isEmpty()) {
        result[i++] = deque.pollFirst();
      }
      return result;
    }
  }

}
