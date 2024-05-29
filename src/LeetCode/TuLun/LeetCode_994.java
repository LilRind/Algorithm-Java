package LeetCode.TuLun;

import java.util.ArrayList;
import java.util.List;

/*
输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
输出：4

输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
输出：-1

输入：grid = [[0,2]]
输出：0
 */

// nettee：什么情况使用 BFS 搜索，队列实现
// https://leetcode.cn/problems/rotting-oranges/solutions/129831/li-qing-si-lu-wei-shi-yao-yong-bfsyi-ji-ru-he-xie-/?envType=study-plan-v2&envId=top-100-liked

// 灵神：多源 BFS
// https://leetcode.cn/problems/rotting-oranges/solutions/2773461/duo-yuan-bfsfu-ti-dan-pythonjavacgojsrus-yfmh/?envType=study-plan-v2&envId=top-100-liked

// 994. 腐烂的橘子
public class LeetCode_994 {

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println(orangesRotting(a));

        int[][] b = new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        System.out.println(orangesRotting(b));

        int[][] c = new int[][]{
                {0, 2}
        };

        System.out.println(orangesRotting(c));


    }

    // 灵神：多源 BFS
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 四方向

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++; // 统计新鲜橘子个数
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j}); // 一开始就腐烂的橘子
                }
            }
        }

        int ans = -1;
        while (!q.isEmpty()) {
            ans++; // 经过一分钟
            List<int[]> tmp = q; // 腐烂的橘子的行、列，可能是多个
            q = new ArrayList<>(); // 清空，之后添加被腐烂的橘子
            for (int[] pos : tmp) { // 这一分钟，每个已经腐烂的橘子行、列
                for (int[] d : DIRECTIONS) { // 四个方向，腐烂新鲜的橘子
                    int i = pos[0] + d[0]; // 行+1
                    int j = pos[1] + d[1]; // 列+1
                    if (0 <= i && i < m && 0 <= j && j < n && grid[i][j] == 1) { // 腐烂新鲜的橘子
                        fresh--; // 新鲜的橘子数量-1
                        grid[i][j] = 2; // 变成腐烂橘子
                        q.add(new int[]{i, j}); // 队列中加入这个新腐烂的橘子
                    }
                }
            }
        }
        // 还存在新鲜的橘子，则无法腐烂所有橘子，返回-1表示不可能，否则返回最小分钟数（可能一来全是腐烂的橘子）
        return fresh > 0 ? -1 : Math.max(ans, 0);
    }


    // 第一次未解出
    /*
    public int orangesRotting(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2){ // 存在腐烂的橘子的网格
                    dfs(grid, i, j); // 记录该网格
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return 0;
    }

    // 此网格是腐烂的橘子，那么感染相邻新鲜橘子
    public int dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if(i-1 >= 0 && grid[i-1][j] == 1) grid[i][j] = 2; // 橘子腐烂

        return 0;
    }
     */
}
