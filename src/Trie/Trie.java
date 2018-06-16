package Trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public Trie() {
        this.root = new TrieNode();
    }

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.endOfWord = false;
        }
    }

    private final TrieNode root;

    public void insert(String word) {
        insertRecursive(root, word, 0);
    }

    private void insertRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            // This is to handle endofWord
            current.endOfWord = true;
            return;
        }

        char searchLetter = word.charAt(index);
        TrieNode node = current.children.get(searchLetter);

        //If the key does not exist then create new.
        if (node == null) {
            node = new TrieNode();
            current.children.put(searchLetter, node);
        }
        insertRecursive(node, word, index + 1);
    }

    public boolean search(String word) {
        return searchRecursive(root, word, 0);
    }

    private boolean searchRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            // This is to handle endofWord
            return current.endOfWord;
        }

        char searchLetter = word.charAt(index);
        TrieNode node = current.children.get(searchLetter);

        if (node == null) {
            return false;
        }
        return searchRecursive(node, word, index + 1);
    }

}
