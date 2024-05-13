package Fuxi.SouSuo.BFS;

import Fuxi.SouSuo.TreeNode.TreeNode;

import java.util.*;


// 103. 二叉树的锯齿形层序遍历
// https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/
// 10:55
public class LeetCode_103 {

    public static void main(String[] args) {
        // 构造树节点
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;


    }
}
