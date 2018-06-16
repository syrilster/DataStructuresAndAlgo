package Trie;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        System.out.println(trie.search("abc"));
    }
}
