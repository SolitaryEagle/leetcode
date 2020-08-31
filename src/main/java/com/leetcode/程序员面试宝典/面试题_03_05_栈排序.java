package com.leetcode.程序员面试宝典;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 覃国强
 * @date 2020-08-31 07:15
 */
public class 面试题_03_05_栈排序 {


    static class SortedStack {

        private Deque<Integer> primary = new ArrayDeque<>();
        private Deque<Integer> assist = new ArrayDeque<>();

        public SortedStack() {

        }

        public void push(int val) {
            if (primary.isEmpty()) {
                primary.push(val);
            } else {
                while (primary.peek() != null && primary.peek() < val) {
                    assist.push(primary.pop());
                }
                primary.push(val);
                while (!assist.isEmpty()) {
                    primary.push(assist.pop());
                }
            }
        }

        public void pop() {
            if (!primary.isEmpty()) {
                primary.pop();
            }
        }

        public int peek() {
            return primary.isEmpty() ? -1 : primary.peek();
        }

        public boolean isEmpty() {
            return primary.isEmpty();
        }
    }
}
