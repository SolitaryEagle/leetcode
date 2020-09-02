package com.leetcode.程序员面试宝典;

import com.leetcode.common.model.TreeNode;

/**
 * @author 覃国强
 * @date 2020-09-02 07:35
 */
public class 面试题_04_12_求和路径 {


    static class Solution {

        public int pathSum(TreeNode root, int sum) {

            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                return root.val == sum ? 1 : 0;
            }

            int leftSum = pathSum(root.left, sum);
            int leftSubSum = pathSubSum(root.left, sum - root.val);
            int rightSum = pathSum(root.right, sum);
            int rightSubSum = pathSubSum(root.right, sum - root.val);

            return leftSum + leftSubSum + rightSum + rightSubSum + (sum == root.val ? 1 : 0);

        }


        private int pathSubSum(TreeNode node, int subSum) {

            if (node == null) {
                return 0;
            }

            int leftSubSum = pathSubSum(node.left, subSum - node.val);
            int rightSubSum = pathSubSum(node.right, subSum - node.val);

            return leftSubSum + rightSubSum + (subSum == node.val ? 1 : 0);
        }
    }

}
