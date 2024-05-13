package Fuxi.SouSuo.DFS;


// 好久没看了BFS，没思路
// 17:18 - 17:24
// 111. 二叉树的最小深度
// https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/

import Lianxi.SouSuo.TreeNode.TreeNode;

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

    }



}