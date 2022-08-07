package BFS;

import java.util.*;

public class ReachableNodesWithRestrictions {
    /**
     * There is an undirected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
     *
     * You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree. You are also given an integer array restricted which represents restricted nodes.
     *
     * Return the maximum number of nodes you can reach from node 0 without visiting a restricted node.
     *
     * Note that node 0 will not be a restricted node.
     * **/

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0]))
                map.put(edge[0], new ArrayList<>());
            if (!map.containsKey(edge[1]))
                map.put(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> unreachable = new HashSet<>();
        for (int i : restricted)
            unreachable.add(i);

        int count = 1;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer> q = new LinkedList<>();
        for (int i : map.get(0)) {
            if (unreachable.contains(i))
                continue;
            q.offer(i);
            visited.add(i);
            count++;
        }


        while (!q.isEmpty()) {
            List<Integer> points = map.get(q.poll());
            for (int point: points) {
                if (unreachable.contains(point) || visited.contains(point))
                    continue;
                q.offer(point);
                visited.add(point);
                count++;
            }
        }

        return count;
    }
}
