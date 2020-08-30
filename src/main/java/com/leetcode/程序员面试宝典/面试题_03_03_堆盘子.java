package com.leetcode.程序员面试宝典;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author 覃国强
 * @date 2020-08-30 11:42
 */
public class 面试题_03_03_堆盘子 {

    public static void main(String[] args) {

        StackOfPlates stackOfPlates = new StackOfPlates(2);

        for (int i = 0; i < 100; ++i) {
            stackOfPlates.push(i);
        }

        System.out.println(stackOfPlates.popAt(0));
        System.out.println(stackOfPlates.popAt(0));
        System.out.println(stackOfPlates.popAt(0));
        System.out.println(stackOfPlates.popAt(0));


        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());


    }



    static class StackOfPlates {

        private int cap;
        private List<Deque<Integer>> list;

        public StackOfPlates(int cap) {
            this.cap = cap;
            this.list = new ArrayList<>();
        }

        public void push(int val) {
            if (cap <= 0) {
                return;
            }
            if (list.size() == 0) {
                Deque<Integer> deque = new ArrayDeque<>(cap);
                deque.push(val);
                list.add(deque);
            } else {
                Deque<Integer> deque = list.get(list.size() - 1);
                if (deque.size() == cap) {
                    Deque<Integer> newDeque = new ArrayDeque<>(cap);
                    newDeque.push(val);
                    list.add(newDeque);
                } else {
                    deque.push(val);
                }
            }
        }

        public int pop() {
            return popAt(list.size() - 1);
        }

        public int popAt(int index) {
            if (index < 0 || index >= list.size()) {
                return -1;
            }
            Deque<Integer> deque = list.get(index);
            Integer pop = deque.pop();
            if (deque.isEmpty()) {
                list.remove(index);
            }
            return pop;
        }
    }

}
