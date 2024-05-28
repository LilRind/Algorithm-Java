package LeetCode.ErChaShu;

import LeetCode.ErChaShu.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static LeetCode.ErChaShu.DFS.LeetCode_111.dfs;
/*
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]

输入：root = [1]
输出：[[1]]

输入：root = []
输出：[]
 */

// 重点关注
// 102. 二叉树的层序遍历
public class LeetCode_102 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        // 构建链接关系
        a.left = node2;
        a.right = node3;
        node3.left = node4;
        node3.right = node5;

        TreeNode b = new TreeNode(1);

        TreeNode c = null;

        System.out.println(levelOrder(a));
        System.out.println(levelOrder(b));
        System.out.println(levelOrder(c));
    }


    // 第一次未解出，详细看官方答案
//    public static List<List<Integer>> levelOrder(TreeNode root) {
//        if(root == null){
//            return null;
//        }
//        Queue queue = new LinkedList();
//        List res = new ArrayList<List<Integer>>(); // 返回结果List
//        List list = new ArrayList<Integer>();
//        queue.add(root);
//        while(queue.size() > 0){
//            TreeNode temp = queue.poll();
//
//            queue.add()
//        }
//        return null;
//
//    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 构建返回结果
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        // 如果根节点为空，则直接返回ret，此时ret为空
        if (root == null) {
            return ret;
        }
        // 构建队列，确保层序遍历顺序
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 把root节点装入队列
        queue.offer(root);
        // 如果队列不为空，为空则代表节点遍历完闭
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

}
