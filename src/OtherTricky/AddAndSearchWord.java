package OtherTricky;

public class AddAndSearchWord {
/*
    Design a data structure that supports the following two operations:

    void addWord(word)
    bool search(word)
    search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
*/


    private class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root = new TrieNode();

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chs, int idx, TrieNode node) {
        if (idx == chs.length) return node.isWord;
        if (chs[idx] == '.') {
            for (int i = 0; i < node.children.length; i++)
                if (node.children[i] != null && match(chs, idx + 1, node.children[i]))
                    return true;
        } else {
            return node.children[chs[idx] - 'a'] != null && match(chs, idx + 1, node.children[chs[idx] - 'a']);
        }
        return false;
    }
}
