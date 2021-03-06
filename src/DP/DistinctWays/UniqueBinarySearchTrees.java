package DP.DistinctWays;

public class UniqueBinarySearchTrees {

    //Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

    public int numTrees(int n) {
        int[] G = new int[n + 1];

        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //choose i as the root, j as sub tree root
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }

}
