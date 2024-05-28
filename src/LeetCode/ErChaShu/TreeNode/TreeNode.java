package LeetCode.ErChaShu.TreeNode;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 深度遍历打印二叉树节点的值
    public static void printDfs(TreeNode root){
        if(root != null) System.out.print(root.val + " ");
        if(root.left != null) printDfs(root.left);
        if(root.right != null) printDfs(root.right);
    }

}
