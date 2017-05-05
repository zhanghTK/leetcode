package tk.zhangh.leetcode.medium;

import java.util.HashMap;

/**
 * Created by ZhangHao on 2017/5/4.
 */
public class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();

        TrieNode p = root;
        int i = 0;

        while (i < chars.length) {
            TrieNode next = p.nexts.get(chars[i]);
            if (next != null) {
                p = next;
                i++;
            } else {
                break;
            }
        }

        while (i < chars.length) {
            TrieNode newTrie = new TrieNode();
            p.nexts.put(chars[i], newTrie);
            p = newTrie;
            i++;
        }

        p.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode child = p.nexts.get(word.charAt(i));
            if (child == null) {
                return false;
            }
            p = child;
        }
        return p.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode child = p.nexts.get(prefix.charAt(i));
            if (child == null) {
                return false;
            }
            p = child;
        }

        return true;
    }

    private class TrieNode {
        boolean isWord = false;
        HashMap<Character, TrieNode> nexts = new HashMap<>();
    }
}
