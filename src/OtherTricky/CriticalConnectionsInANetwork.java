package OtherTricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork {
    /**
     * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.
     *
     * A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
     *
     * Return all critical connections in the network in any order.
     * **/

    int id = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (List<Integer> conn : connections) {
            int from = conn.get(0), to = conn.get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        int[] ids = new int[n], low = new int[n];
        Arrays.fill(ids, -1);
        for (int i = 0; i < n; i++) {
            if (ids[i] == -1)
                dfs(i, i, ids, low, graph, res);
        }

        return res;
    }

    private void dfs(int from, int prev, int[] ids, int[] low, List<Integer>[] graph, List<List<Integer>> res) {
        ids[from] = low[from] = ++id;
        for (int to : graph[from]) {
            if (to == prev)
                continue;
            if (ids[to] == -1) {
                dfs(to, from, ids, low, graph, res);
                low[from] = Math.min(low[from], low[to]);
                if (low[to] > ids[from])
                    res.add(Arrays.asList(from, to));
            } else {
                low[from] = Math.min(low[from], ids[to]);
            }
        }
    }
}
