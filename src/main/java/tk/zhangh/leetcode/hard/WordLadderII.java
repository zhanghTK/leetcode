package tk.zhangh.leetcode.hard;

import java.util.*;

/**
 * BFS,DFS
 * <p/>
 * Created by ZhangHao on 17/4/23.
 */
public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> nodeNeighbors = new HashMap<>();  // Neighbors for every node
        Map<String, Integer> distance = new HashMap<>();  // Distance of every node from the start node

        dict.add(start);
        bfs(start, end, dict, nodeNeighbors, distance);
        dfs(start, end, nodeNeighbors, distance, new ArrayList<>(), res);
        return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
        for (String str : dict)
            nodeNeighbors.put(str, new ArrayList<>());

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                List<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {  // Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))  // Found the shortest path
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd)
                break;
        }
    }

    // Find all next level nodes.
    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> neighbors = new ArrayList<>();
        char chs[] = word.toCharArray();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) {
                    continue;
                }
                char oldChar = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    neighbors.add(String.valueOf(chs));
                }
                chs[i] = oldChar;
            }

        }
        return neighbors;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance, List<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<>(solution));
        } else {
            nodeNeighbors.get(cur).stream().filter(next -> distance.get(next) == distance.get(cur) + 1).forEach(next -> {
                dfs(next, end, nodeNeighbors, distance, solution, res);
            });
        }
        solution.remove(solution.size() - 1);
    }
}
