package Trie;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abcd");
        System.out.println("----- Before Deleting ----");
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("bca"));
        System.out.println(trie.search("abcd"));

        trie.delete("abc");
        //trie.delete("abcd");

        System.out.println("----- After Deleting ----");
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("abcd"));
    }
}
