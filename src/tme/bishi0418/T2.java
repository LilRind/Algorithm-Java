package tme.bishi0418;

import java.util.LinkedList;
import java.util.Queue;

// https://blog.csdn.net/Qmtdearu/article/details/137965522
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class T2 {
    public TreeNode createBalancedTree(int n) {
        if (n == 0) return null;
        TreeNode root = new TreeNode(1 << (n - 1));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int level = n - 1; level > 0; level--) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                node.left = new TreeNode(1 << (level - 1));
                node.right = new TreeNode(1 << (level - 1));
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return root;
    }
}

