package com.leetcode.common.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 覃国强
 * @date 2020-08-30 10:11
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "val=" + val +
            '}';
    }

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static ListNode randomCycleListNode(int length) {
        return randomCycleListNode(length, 0, 10);
    }

    public static ListNode randomCycleListNode(int length, int origin, int bound) {
        List<ListNode> list = new ArrayList<>();
        ListNode head = new ListNode(random.nextInt(origin, bound));
        ListNode cur = head;
        list.add(head);
        for (int i = 1; i < length; ++i) {
            ListNode tmp = new ListNode(random.nextInt(origin, bound));
            list.add(tmp);
            cur.next = tmp;
            cur = tmp;
        }
        // 结环
        int index = random.nextInt(list.size());
        cur.next = list.get(index);
        return head;
    }

    public static ListNode randomListNode(int length) {
        return randomListNode(length, 0, 10);
    }

    public static ListNode randomListNode(int length, int bound) {
        return randomListNode(length, 0, bound);
    }

    public static ListNode randomListNode(int length, int origin, int bound) {
        ListNode head = new ListNode(random.nextInt(origin, bound));
        ListNode cur = head;
        for (int i = 1; i < length; ++i) {
            ListNode tmp = new ListNode(random.nextInt(origin, bound));
            cur.next = tmp;
            cur = tmp;
        }
        return head;
    }

    public static void printListNode(ListNode head) {

        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }

        System.out.println();
        System.out.println("==========================");

    }
}
