package tk.zhangh.leetcode.medium;


import java.util.*;
import java.util.stream.Collectors;

/**
 * tag:图,BFS
 * 每个字符串表示图的一个点
 * 如果两个字符串相差一个字符则两个点之间有一条边
 * 一个点最大可能存在25*L条边(L为字符串长度)
 * <p/>
 * Created by ZhangHao on 17/4/23.
 */
public class WordLadder {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        new WordLadder().ladderLength("hit", "cog", list);
    }

    public int ladderLength(String start, String end, List<String> wordList) {
        if (start.equals(end)) {
            return 1;
        }
        Set<String> dict = wordList.stream().collect(Collectors.toSet());
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            for (int i = 0; i < queue.size(); i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, dict)) {
                    if (visited.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }

                    visited.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }

        return 0;
    }

    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }

    // replace character of a string at given index to a given character
    // return a new string
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
