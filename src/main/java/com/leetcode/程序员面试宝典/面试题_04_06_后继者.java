package com.leetcode.程序员面试宝典;

import com.leetcode.common.model.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 覃国强
 * @date 2020-09-01 07:46
 */
public class 面试题_04_06_后继者 {


    static class Solution {

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

            if (root == null || p == null) {
                return null;
            }

            if (root == p) {
                return root.right;
            }

            List<TreeNode> inOrderResult = new ArrayList<>();
            inOrder(root, inOrderResult);

            for (int i = 0; i < inOrderResult.size() - 1; ++i) {

                if (p == inOrderResult.get(i)) {
                    return inOrderResult.get(i + 1);
                }

            }
            return null;
        }

        private void inOrder(TreeNode node, List<TreeNode> list) {

            if (node == null) {
                return;
            }
            inOrder(node.left, list);
            list.add(node);
            inOrder(node.right, list);

        }


    }

}
