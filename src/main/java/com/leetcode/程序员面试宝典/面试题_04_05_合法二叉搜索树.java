package com.leetcode.程序员面试宝典;

import com.leetcode.common.model.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 覃国强
 * @date 2020-09-01 07:25
 */
public class 面试题_04_05_合法二叉搜索树 {

    static class Solution {

        public boolean isValidBST(TreeNode root) {

            if (root == null) {
                return true;
            }

            List<TreeNode> inOrderResult = new ArrayList<>();
            inOrder(root, inOrderResult);

            for (int i = 0; i < inOrderResult.size() - 1; ++i) {
                if (inOrderResult.get(i).val >= inOrderResult.get(i + 1).val) {
                    return false;
                }
            }

            return true;

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
