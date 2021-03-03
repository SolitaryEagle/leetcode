package com.leetcode.程序员面试宝典.medium;

import com.leetcode.common.model.ListNode;

/**
 * @author 覃国强
 * @date 2020-08-30 10:36
 */
public class 面试题_02_08_环路检测 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode = ListNode.randomListNode(10);
        ListNode cycleListNode = ListNode.randomCycleListNode(10);

        ListNode detectCycle1 = solution.detectCycle(listNode);
        ListNode detectCycle2 = solution.detectCycle(cycleListNode);

        System.out.println(detectCycle1);
        System.out.println(detectCycle2);

    }

    static public class Solution {

        public ListNode detectCycle(ListNode head) {

            if (head == null || head.next == null) {
                return null;
            }

            ListNode fast = head.next.next;
            ListNode slow = head.next;
            boolean hasCycle = false;

            while (fast != null && fast.next != null && !hasCycle) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast != null && fast == slow) {
                    hasCycle = true;
                }
            }

            while (hasCycle) {
                if (head == fast) {
                    return head;
                }
                head = head.next;
                fast = fast.next;
            }

            return null;
        }
    }

}
