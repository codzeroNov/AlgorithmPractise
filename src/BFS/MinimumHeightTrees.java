package BFS;

import java.util.*;

public class MinimumHeightTrees {
    // the middle node of the tree is the result.
    // every round we remove the leaves, util we get 2 or less nodes.
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        Map<Integer, Set<Integer>> path = new HashMap<>();
        List<Integer> leaves = new ArrayList<>();

        for (int i = 0; i < n; i++)
            path.put(i, new HashSet<>());

        for (int[] edge: edges) {
            path.get(edge[0]).add(edge[1]);
            path.get(edge[1]).add(edge[0]);
        }

        for(int i = 0; i < n; i++)
            if (path.get(i).size() == 1)
                leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leave: leaves) {
                // there is only one father for a leave
                int father = path.get(leave).iterator().next();
                path.get(father).remove(leave);
                if (path.get(father).size() == 1)
                    newLeaves.add(father);
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
