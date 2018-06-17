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
            // This is to handle end of Word
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

    boolean search(String word) {
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

    /**
     * Delete word from trie.
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.endOfWord)
                return false;
            //In case of delete abc, we can't delete the next node as abcd will also be lost. So set the flag to false
            // as it does not give search result.
            current.endOfWord = false;
            return current.children.size() == 0;
        }

        char searchLetter = word.charAt(index);
        TrieNode node = current.children.get(searchLetter);
        if (node == null)
            return false;

        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.children.remove(searchLetter);
            return current.children.size() == 0;
        }
        return false;
    }

}
