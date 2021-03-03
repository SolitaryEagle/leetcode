package com.leetcode.程序员面试宝典.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 覃国强
 * @date 2020-08-31 07:30
 */
public class 面试题_04_01_节点间通路 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] graph = {
            {0, 1},
            {0, 3},
            {0, 10},
            {0, 18},
            {1, 2},
            {1, 7},
            {1, 11},
            {1, 12},
            {2, 4},
            {2, 5},
            {2, 13},
            {2, 16},
            {3, 6},
            {3, 8},
            {4, 9},
            {5, 17},
            {7, 20},
            {7, 22},
            {8, 10},
            {10, 19},
            {11, 15},
            {13, 14},
            {14, 21},
            {15, 23},
            {19, 24},
            {20, 22}
        };

        System.out.println(solution.findWhetherExistsPath(3, graph, 0, 2));


    }


    static class Solution {

        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {

            List<Integer> passed = new ArrayList<>();
            passed.add(target);

            for (int j = 0; j < passed.size(); ++j){
                for (int i = 0; i < graph.length; ++i) {
                    if (graph[i][1] == passed.get(j) && !passed.contains(graph[i][0])) {
                        if (graph[i][0] == start) {
                            return true;
                        }
                        passed.add(graph[i][0]);
                    }
                }
            }

            return false;


        }

        public boolean findWhetherExistsPath2(int n, int[][] graph, int start, int target) {

            List<Integer> passed = new ArrayList<>();
            passed.add(start);

            for (int j = 0; j < passed.size(); ++j){
                for (int i = 0; i < graph.length; ++i) {
                    if (passed.contains(target)) {
                        return true;
                    }
                    if (graph[i][0] == passed.get(j) && !passed.contains(graph[i][1])) {
                        passed.add(graph[i][1]);
                    }
                }
            }

            return false;


        }

        private boolean doFind(int n, int[][] graph, int start, int target, List<Integer> passed) {
            if (passed.size() == n) {
                return false;
            }

            for (int i = 0; i < graph.length; ++i) {
                if (graph[i][0] == start) {
                    if (graph[i][1] == target) {
                        return true;
                    }
                    if (!passed.contains(graph[i][1])) {
                        passed.add(graph[i][1]);
                        boolean findResult = doFind(n, graph, graph[i][1], target, passed);
                        if (findResult) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

}
