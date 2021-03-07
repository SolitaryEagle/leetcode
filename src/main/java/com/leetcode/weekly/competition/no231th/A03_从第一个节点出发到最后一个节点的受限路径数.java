package com.leetcode.weekly.competition.no231th;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 覃国强
 * @date 2021-03-07 11:21
 */
public class A03_从第一个节点出发到最后一个节点的受限路径数 {


  public static void main(String[] args) {
    Solution solution = new Solution();

    int n = 7;
    int[][] edges = 
{{1,3,1},{4,1,2},{7,3,4},{2,5,3},{5,6,1},{6,7,2},{7,5,3},{2,6,4}};
    solution.countRestrictedPaths(n, edges);
    
  }

  static
  class Solution {

    public int countRestrictedPaths(int n, int[][] edges) {

      int[][] graph = new int[n + 1][n + 1];
      for (int i = 0; i <= n; ++i) {
        for (int j = 0; j <= n; ++j) {
          if (i != j) {
            graph[i][j] = Integer.MAX_VALUE;
          }
        }
      }

      for (int[] edge : edges) {
        graph[edge[0]][edge[1]] = edge[2];
        graph[edge[1]][edge[0]] = edge[2];
      }

      // 求最短路径
      int[] dist = distanceToLastNode(n, graph);

      System.out.println(Arrays.toString(dist));

      return 0;
    }

    private int[] distanceToLastNode(int n, int[][] graph) {
      int[] dist = new int[n + 1];
      for (int i = 1; i < n; ++i) {
        dist[i] = graph[n][i];
      }

      Set<Integer> nodes = new HashSet<>();
      nodes.add(n);
      while (nodes.size() < n) {
        int minNode = -1;
        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
          if (!nodes.contains(i) && dist[i] < minDist) {
            minDist = dist[i];
            minNode = i;
          }
        }

        nodes.add(minNode);

        for (int i = 1; i < n; ++i) {
          if (graph[i][minNode] != Integer.MAX_VALUE) {
            dist[i] = Math.min(dist[i], graph[i][minNode] + minDist);
          }
        }
      }
      return dist;
    }
  }

}
