package Lianxi.SouSuo.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import Lianxi.SouSuo.TreeNode.TreeNode;

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
        System.out.println(minDepth(t0));
    }
    static class QueueNode {
        TreeNode node; // 节点
        int depth; // 节点深度

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }

        return 0;
    }
}


/*
// 2ms
class Solution {
        public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int curDepth = 0;
        q.offer(root);
        if (root == null) {
            return 0;
        }
        while(!q.isEmpty()){
            int queueCount = q.size();
            while(--queueCount >= 0) { // 一次循环代表一层全部遍历完
                TreeNode t = q.poll();
                if (t != null) {
                    if (t.left == null && t.right == null) {
                        return  curDepth + 1;
                    }
                    q.offer(t.left);
                    q.offer(t.right);
                }
            }
            curDepth++;
        }
        return curDepth;
    }
}
 */


/*

class Solution {
    public int minDepth(TreeNode root) {
        Stack stack = new Stack();
        int min = 0;
        if(root != null){
            stack.push(root);
            minDepth(root.left);
            minDepth(root.right);
            TreeNode tem = stack.pop();
            Math.min(tem, min)
            System.out.println(tem);
        }
    }
}

*/
