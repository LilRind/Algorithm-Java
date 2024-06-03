package LeetCode.ErChaShu;


// 好久没看了BFS，没思路
// 17:18 - 17:24
// 111. 二叉树的最小深度
// https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
//class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//}

import LeetCode.ErChaShu.TreeNode.TreeNode;

public class LeetCode_111 {
    public static void main(String[] args) {
        // 构造二叉树
        TreeNode t0 = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t5 = new TreeNode(15);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(1);
        TreeNode t8 = new TreeNode(31);
        t0.left = t1;
        t0.right = t2;
        t2.left = t5;
        t2.right = t6;
        t5.right = t7;
        t7.left = t8;
//      // 先序遍历
        System.out.print("dfs先序遍历：");
        dfs(t0);
        System.out.println();
        // dfs最大的深度
        System.out.println("最大深度："+dfsMaxDepth(t0, 0));
        // dfs最小的深度
        System.out.println("最小深度："+dfsMinDepth(t0, 0));
        // dfs最大深度：只有一个输入参数(root)的函数
        System.out.println("dfs最大深度：只有一个输入参数(root)的函数：" + maxDepth(t0));
    }

    // dfs求最大深度(root，depth)
    public static int dfsMaxDepth(TreeNode root, int depth){
        if(root == null){
            return depth;
        }
        return Math.max(dfsMaxDepth(root.left, depth+1), dfsMaxDepth(root.right, depth+1));
    }

    // dfs求最小深度
    public static int dfsMinDepth(TreeNode root, int depth){
        if(root == null){
            return depth;
        }
        return Math.min(dfsMaxDepth(root.left, depth+1), dfsMaxDepth(root.right, depth+1));
    }

    // dfs深度遍历树
    public static void dfs(TreeNode root){
        if(root != null) System.out.print(root.val + " ");
        if(root.left != null) dfs(root.left);
        if(root.right != null) dfs(root.right);

    }

    // 官方dfs最小深度：只有一个输入参数(root)的函数
    public static int minDepth(TreeNode root) {
        // 判断当前节点是否null
        if (root == null) {
            return 0; // 返回，无深度（深度为0）
        }

        if (root.left == null && root.right == null) { // 左右节点null，此为叶子节点
            return 1; // 返回1深度，1是因为存在当前节点，但无子节点
        }

        int min_depth = Integer.MAX_VALUE; // 保留最小值，主要是为了比较左、右节点深度谁更小
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth); // 先记录左节点深度
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth); // 再比较左、右节点深度谁更小
        }
        return min_depth + 1; // 左、右节点深度的更小值，+1是因为存在上一父节点
    }


    // dfs最大深度：只有一个输入参数(root)的函数
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){ // 左、右节点都为空，此为叶子节点
            return 1; // 返回1深度，1是因为存在当前节点，但无子节点
        }

        int max = Integer.MIN_VALUE;
        if(root.left != null){
            max =  Math.max(maxDepth(root.left), max);
        }
        if(root.right != null){
            max = Math.max(maxDepth(root.right), max);
        }
        return max + 1; // 左、右节点深度的更大值，+1是因为存在上一父节点
    }

}