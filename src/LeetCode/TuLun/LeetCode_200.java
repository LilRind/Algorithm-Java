package LeetCode.TuLun;

import java.util.LinkedList;
import java.util.Queue;

// K神
// https://leetcode.cn/problems/number-of-islands/solutions/16884/number-of-islands-shen-du-you-xian-bian-li-dfs-or-/?envType=study-plan-v2&envId=top-100-liked

// 重点关注
// 200.岛屿数量
public class LeetCode_200 {
    public static void main(String[] args) {
        char[][] a = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        System.out.println(numIslands(a));

        char[][] b = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        System.out.println(numIslands(b));

    }

    // 第一次未解出

    // K神：DFS，就是最快的，其它只不过是在这之上的小小的修改，掌握
    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){ // 存在陆地的网格
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private static void dfs(char[][] grid, int i, int j){
        // 终止递归条件，包含一些边界条件
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0'; // 将岛屿所有节点删除，以免之后重复搜索相同岛屿。
        dfs(grid, i + 1, j); // 向下
        dfs(grid, i, j + 1); // 向右
        dfs(grid, i - 1, j); // 向上
        dfs(grid, i, j - 1); // 向左
    }


    // K神：BFS，可以掌握
    /*
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j){
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[] { i, j });
        while(!list.isEmpty()){
            int[] cur = list.remove();
            i = cur[0]; j = cur[1];
            if(0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                list.add(new int[] { i + 1, j });
                list.add(new int[] { i - 1, j });
                list.add(new int[] { i, j + 1 });
                list.add(new int[] { i, j - 1 });
            }
        }
    }
     */

}
