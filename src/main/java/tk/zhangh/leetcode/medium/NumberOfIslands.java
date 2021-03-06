package tk.zhangh.leetcode.medium;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * Created by ZhangHao on 2017/5/3.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    search(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void search(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '0';
        search(grid, x - 1, y);
        search(grid, x + 1, y);
        search(grid, x, y - 1);
        search(grid, x, y + 1);
    }
}
