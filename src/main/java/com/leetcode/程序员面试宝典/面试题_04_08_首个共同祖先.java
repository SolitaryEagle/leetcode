package com.leetcode.程序员面试宝典;

import com.leetcode.common.model.TreeNode;

/**
 * @author 覃国强
 * @date 2020-09-01 08:13
 */
public class 面试题_04_08_首个共同祖先 {

    class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (root == null || root == p || root == q) {
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null) {
                return root;
            }

            return left != null ? left : right;



        }

    }

}
