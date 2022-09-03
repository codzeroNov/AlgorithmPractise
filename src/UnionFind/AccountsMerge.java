package UnionFind;

import java.util.*;

public class AccountsMerge {
    /**
     * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
     *
     * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
     *
     * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
     * **/

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        Map<String, Integer> mailToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String mail = account.get(j);
                if (!mailToIndex.containsKey(mail)) {
                    mailToIndex.put(mail, i);
                } else {
                    int parentIndx = mailToIndex.get(mail);
                    uf.union(parentIndx, i);
                }
            }
        }

        Map<Integer, Set<String>> indexToMails = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            int parentIndex = uf.find(i);

            indexToMails.putIfAbsent(parentIndex, new HashSet<>());
            Set<String> mails = indexToMails.get(parentIndex);
            for (int j = 1; j < account.size(); j++)
                mails.add(account.get(j));

        }

        List<List<String>> res = new ArrayList<>();
        for (int idx : indexToMails.keySet()) {
            List<String> account = accounts.get(idx);
            List<String> sub = new LinkedList<>();
            sub.addAll(indexToMails.get(idx));
            Collections.sort(sub);
            sub.add(0, account.get(0));
            res.add(sub);
        }

        return res;
    }

    private class UnionFind {
        int size;
        int[] parents;
        public UnionFind(int size) {
            this.size = size;
            this.parents = new int[size];
            for (int i = 0; i < parents.length; i++)
                parents[i] = i;
        }

        public void union(int a, int b) {
            parents[find(a)] = parents[find(b)];
        }

        public int find(int target) {
            while (target != parents[target])
                target = parents[target];
            return target;
        }
    }
}
