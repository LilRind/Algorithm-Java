package Fuxi.SouSuo.BFS;

import Fuxi.SouSuo.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 好久没看了BFS，没思路
// 17:18 - 17:24
// 111. 二叉树的最小深度
// https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/


public class LeetCode_111 {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t5 = new TreeNode(15);
        TreeNode t6 = new TreeNode(7);
//        t0.left = t1;
        t0.right = t2;
        t2.left = t5;
        t2.right = t6;


    }

}


