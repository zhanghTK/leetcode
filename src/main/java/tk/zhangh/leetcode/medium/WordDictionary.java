package tk.zhangh.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * Created by ZhangHao on 2017/5/4.
 */
public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchNode(word, root);
    }

    private boolean searchNode(String word, TrieNode node) {

        if (node == null) {
            return false;
        }

        if (word.length() == 0) {
            return node.isWord;
        }

        Map<Character, TrieNode> nexts = node.nexts;
        if (word.charAt(0) == '.') {
            for (char key : nexts.keySet()) {
                if (word.length() == 1 && nexts.get(key).isWord) {
                    return true;
                }
                if (searchNode(word.substring(1), nexts.get(key))) {
                    return true;
                }
            }
            return false;
        } else if (!nexts.containsKey(word.charAt(0))) {
            return false;
        } else {
            return searchNode(word.substring(1), nexts.get(word.charAt(0)));
        }
    }

    private class TrieNode {

        boolean isWord;
        HashMap<Character, TrieNode> nexts = new HashMap<>();
    }
}
