package com.Interview.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RouteBetweenNodes {

  // 利用visited记录路径访问情况
  boolean[] visited = null;

  public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {

    // 构建邻接表
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(i, new HashSet<>());
    }
    int len = graph.length;
    for (int j = 0; j < len; j++) {
      // 根据graph数组，把边的头到尾存在edges里
      map.get(graph[j][0]).add(graph[j][1]);
    }
    visited = new boolean[n];
    return recursionForFindPath(map, start, target);
  }

  private boolean recursionForFindPath(Map<Integer, Set<Integer>> map, int start, int target) {
    // list为start为开始的边
    Set<Integer> list = map.get(start);
    if (list.contains(target)) {
      // 如果target已经在list列表里，说明可以直接到达，直接返回true
      return true;
    } else if (!visited[start]) {
      visited[start] = true;
      // 如果找不到就在list这个候选列表里继续以当前候选节点为头开始找
      for (int cur : list) {
        // 如果说找到了， 就直接返回true
        if (recursionForFindPath(map, cur, target)) {
          return true;
        }
      }
      visited[start] = true;
    }
    return false;
  }

  private static void buildMap(Map<Integer, Set<Integer>> map, int node1, int node2) {
    if (map.containsKey(node1)) {
      Set<Integer> integers = map.get(node1);
      integers.add(node2);
    } else {
      Set<Integer> set = new HashSet<>();
      set.add(node2);
      map.put(node1, set);
    }
  }

  public static void main(String[] args) {
    RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
    int[][] graph = { { 0, 1 }, { 0, 2 }, { 0, 4 }, { 0, 4 }, { 0, 1 }, { 1, 3 }, { 1, 4 }, { 1, 3 }, { 2, 3 },
        { 3, 4 } };
    routeBetweenNodes.findWhetherExistsPath(5, graph, 0, 3);
  }
}
