package com.leetcode.程序员面试宝典;

import com.leetcode.common.model.ListNode;
import com.leetcode.common.model.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author 覃国强
 * @date 2020-09-01 07:13
 */
public class 面试题_04_03_特定深度节点链表 {

    static class Solution {

        public ListNode[] listOfDepth(TreeNode tree) {

            if (tree == null) {
                return new ListNode[0];
            }

            Deque<TreeNode> curLayer = new ArrayDeque<>();
            Deque<TreeNode> nextLayer = new ArrayDeque<>();

            curLayer.add(tree);

            List<ListNode> list = new ArrayList<>();

            while (!curLayer.isEmpty()) {
                ListNode listNode = new ListNode(0);
                ListNode head = listNode;
                while (!curLayer.isEmpty()) {
                    TreeNode treeNode = curLayer.poll();
                    listNode.next = new ListNode(treeNode.val);
                    listNode = listNode.next;

                    if (treeNode.left != null) {
                        nextLayer.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        nextLayer.add(treeNode.right);
                    }
                }
                if (head.next != null) {
                    list.add(head.next);
                }
                curLayer = nextLayer;
                nextLayer = new ArrayDeque<>();
            }

            return list.toArray(new ListNode[0]);
        }
    }

}
