package LeetCode.ErChaShu;

import LeetCode.ErChaShu.TreeNode.TreeNode;

// 灵神：递归讲解
// https://www.bilibili.com/video/BV1UD4y1Y769/

// 104. 二叉树的最大深度
public class LeetCode_104 {
    public static void main(String[] args) {

        TreeNode a = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        a.left = node2;
        a.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(maxDepth(a));

    }

    // 第一次解出，K神后序遍历应该是最简单的
    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else { // 不为空
            int left = maxDepth(root.left) + 1;
            int right = maxDepth(root.right) + 1;
            return Math.max(left, right);
        }
    }

    // 官方题解：DFS、BFS
    /*
    // DFS
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    // BFS
        public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
     */


    // K神
    /*
    // 方法一：后序遍历(DFS)
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 方法二：层序遍历（BFS）
        public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<>() {{ add(root); }}, tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
     */
}
