package com.leetcode.程序员面试宝典.medium;

import com.leetcode.common.model.ListNode;
import java.util.Random;

/**
 * @author 覃国强
 * @date 2020-08-30 09:32
 */
public class 面试题_02_04_分割链表 {

    private static final Random random = new Random();

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = ListNode.randomListNode(5, 10);

        System.out.print("partition before: ");
        ListNode.printListNode(head);

        int baseValue = random.nextInt(10);
        System.out.println("baseValue: " + baseValue);
        ListNode partition = solution.partition(head, baseValue);

        System.out.print("partition after: ");
        ListNode.printListNode(partition);

    }

    /**
     * Definition for singly-linked list.
     * <pre>
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     * </pre>
     */
    static class Solution {

        public ListNode partition(ListNode head, int x) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode prefix = head;
            ListNode suffix = head;
            ListNode cur = head.next;

            prefix.next = null;

            while (cur != null) {
                ListNode next = cur.next;
                if (cur.val < x) {
                    cur.next = prefix;
                    prefix = cur;
                } else {
                    suffix.next = cur;
                    suffix = suffix.next;
                }
                cur = next;
            }
            suffix.next = null;

            return prefix;
        }
    }

}
