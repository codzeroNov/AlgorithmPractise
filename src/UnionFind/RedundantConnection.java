package UnionFind;

public class RedundantConnection {
    /**
     * In this problem, a tree is an undirected graph that is connected and has no cycles.
     *
     * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
     *
     * Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
     * **/

    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[2001];
        for (int i = 0; i < parents.length; i++)
            parents[i] = i;

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (find(parents, from) == find(parents, to))
                return edge;
            union(parents, from, to);
        }

        return null;
    }

    private int find(int[] parents, int target) {
        while (parents[target] != target)
            target = parents[target];
        return target;
    }

    private void union(int[] parents, int from, int to) {
        int fromRoot = find(parents, from);
        int toRoot = find(parents, to);
        if (fromRoot != toRoot)
            parents[toRoot] = fromRoot;
    }
}
