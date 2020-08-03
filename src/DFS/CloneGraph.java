package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    /*
        Given a reference of a node in a connected undirected graph.
        Return a deep copy (clone) of the graph.
        Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
    */
    HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return clone(node);
    }

    private Node clone(Node node) {
        if (node == null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);

        Node newNode = new Node(node.val);
        map.put(newNode.val, newNode);

        for (Node neibor : node.neighbors)
            newNode.neighbors.add(clone(neibor));
        return newNode;
    }
}
