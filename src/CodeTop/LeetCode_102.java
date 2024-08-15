package CodeTop;

import LeetCode.ErChaShu.TreeNode.TreeNode;

import java.util.*;
/*
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]

输入：root = [1]
输出：[[1]]

输入：root = []
输出：[]
 */

// 灵神：一个队列层序遍历（掌握）。两个数组
// https://leetcode.cn/problems/binary-tree-level-order-traversal/solutions/2049807/bfs-wei-shi-yao-yao-yong-dui-lie-yi-ge-s-xlpz/

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

    // 3
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return List.of();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            while(n-- > 0){
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(level);
        }
        return res;
    }


    // 2

    // 1

    // 灵神：一个队列
    /*
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of(); // 根节点为 null，直接返回
        List<List<Integer>> ans = new ArrayList<>(); // 创建 最终 List
        Queue<TreeNode> q = new ArrayDeque<>(); // 创建队列
        q.add(root); // 根节点入队列
        while (!q.isEmpty()) { // 队列不为空一直循环
            int n = q.size(); // 记录队列的大小
            List<Integer> vals = new ArrayList<>(n); // 创建一个存放元素的临时 List，预分配空间
            while (n-- > 0) { // 根据队列大小循环弹出所有节点，把值依次加入到临时队列，并把当前节点的左、右节点加入队列中
                TreeNode node = q.poll();
                vals.add(node.val);
                if (node.left != null)  q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ans.add(vals); // 将临时 List 加入到最终 List
        }
        return ans;
    }
     */

    // 灵神：两个数组
    /*
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> cur = List.of(root);
        while (!cur.isEmpty()) {
            List<TreeNode> nxt = new ArrayList<>();
            List<Integer> vals = new ArrayList<>(cur.size()); // 预分配空间
            for (TreeNode node : cur) {
                vals.add(node.val);
                if (node.left != null)  nxt.add(node.left);
                if (node.right != null) nxt.add(node.right);
            }
            cur = nxt;
            ans.add(vals);
        }
        return ans;
    }
     */



    // bfs
    // 官方：队列
    /*
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
            List<Integer> level = new ArrayList<Integer>(); // 每一层的临时存储数组
            int currentLevelSize = queue.size(); // 每一层的节点个数
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll(); // 弹出每一层的
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
    */


}
