package com.leetcode.程序员面试宝典;

import com.leetcode.common.model.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 覃国强
 * @date 2020-09-02 07:20
 */
public class 面试题_04_10_检查子树 {


    static class Solution {

        public boolean checkSubTree(TreeNode t1, TreeNode t2) {

            if (t1 == null && t2 == null) {
                return true;
            }
            if (t1 == null || t2 == null) {
                return t2 == null;
            }

            List<Integer> list1 = new ArrayList<>();
            inOrder(t1, list1);
            List<Integer> list2 = new ArrayList<>();
            inOrder(t2, list2);

            for (int i = 0; i < list1.size(); ++i) {
                if (list1.get(i).equals(list2.get(0))) {
                    if (list1.size() - i < list2.size()) {
                        return false;
                    }
                    boolean isEqual = true;
                    for (int x = i, y = 0; y < list2.size(); ++x, ++y) {
                        if (!list1.get(x).equals(list2.get(y))) {
                            isEqual = false;
                            break;
                        }
                    }
                    if (isEqual) {
                        return true;
                    }
                }
            }

            return false;
        }

        private void inOrder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }

}
