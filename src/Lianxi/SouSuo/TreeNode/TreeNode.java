package Lianxi.SouSuo.TreeNode;

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

    public void dfs(TreeNode root){
        if(root != null) System.out.print(root.val + " ");
        if(root.left != null) dfs(root.left);
        if(root.right != null) dfs(root.right);

    }

}
