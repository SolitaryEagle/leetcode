package com.leetcode.程序员面试宝典;

import com.leetcode.common.model.ListNode;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 覃国强
 * @date 2020-08-30 10:10
 */
public class 面试题_02_05_链表求和 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        ThreadLocalRandom random = ThreadLocalRandom.current();

        ListNode l1 = ListNode.randomListNode(random.nextInt(10), 1, 10);

        ListNode l2 = ListNode.randomListNode(random.nextInt(10), 1, 10);

        System.out.print("l1: ");
        ListNode.printListNode(l1);
        System.out.print("l2: ");
        ListNode.printListNode(l2);

        ListNode res = solution.addTwoNumbers(l1, l2);
        System.out.print("res: ");
        ListNode.printListNode(res);

    }

    static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }

            ListNode head = new ListNode(0);
            ListNode tmp = head;

            int carry = 0;

            while (l1 != null && l2 != null) {
                int res = l1.val + l2.val + carry;
                int curVal = res % 10;
                carry = res / 10;
                tmp.next = new ListNode(curVal);
                tmp = tmp.next;
                l1 = l1.next;
                l2 = l2.next;
            }

            // 处理未完成的 l1
            while (l1 != null) {
                int res = l1.val + carry;
                int curVal = res % 10;
                carry = res / 10;
                tmp.next = new ListNode(curVal);
                tmp = tmp.next;
                l1 = l1.next;
            }

            // 处理未完成的 l2
            while (l2 != null) {
                int res = l2.val + carry;
                int curVal = res % 10;
                carry = res / 10;
                tmp.next = new ListNode(curVal);
                tmp = tmp.next;
                l2 = l2.next;
            }

            // 处理未完成的进位
            if (carry > 0) {
                tmp.next = new ListNode(carry);
                tmp = tmp.next;
            }

            return head.next;
        }
    }

}
