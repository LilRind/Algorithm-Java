package LeetCode.ErChaShu;

import LeetCode.ErChaShu.TreeNode.TreeNode;

/*
输入：root = [1,2,3,4,5]
输出：3
解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。

输入：root = [1,2]
输出：1
 */

// 灵神：递归 + 保存最大深度
// https://leetcode.cn/problems/diameter-of-binary-tree/solutions/2227017/shi-pin-che-di-zhang-wo-zhi-jing-dpcong-taqma/?envType=study-plan-v2&envId=top-100-liked

// 重点关注
// 543. 二叉树的直径
public class LeetCode_543 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        a.left = node2;
        a.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(diameterOfBinaryTree(a));

        TreeNode b = new TreeNode(1);
        TreeNode node6 = new TreeNode(2);

        b.left = node6;

    }

    // 再写，考虑保存最大深度
    private static int ans;

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private static int dfs(TreeNode node) {
        if (node == null)
            return -1; // 下面 +1 后，对于叶子节点就刚好是 0
        int lLen = dfs(node.left) + 1; // 左子树最大链长+1
        int rLen = dfs(node.right) + 1; // 右子树最大链长+1
        ans = Math.max(ans, lLen + rLen); // 两条链拼成路径
        return Math.max(lLen, rLen); // 当前子树最大链长
    }

    // 第一次写，没有考虑保存最大深度。
    // 二叉树的直径可分解成1个节点的左右子树的最大高度
    /*
    二叉树的直径可分解成1个节点的左右子树的最大高度
        public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        return maxDepth(root.left) + maxDepth(root.right);
    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
     */


    // 灵神：
    /*
    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return -1; // 下面 +1 后，对于叶子节点就刚好是 0
        int lLen = dfs(node.left) + 1; // 左子树最大链长+1
        int rLen = dfs(node.right) + 1; // 右子树最大链长+1
        ans = Math.max(ans, lLen + rLen); // 两条链拼成路径
        return Math.max(lLen, rLen); // 当前子树最大链长
    }
     */

    // 之前的写法，类似于官方
    /*
    int ans = 0; // 最大深度+1
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
     */
}
