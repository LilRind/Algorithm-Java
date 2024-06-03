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
        if(root == null) { // 为空，输出null，直接返回
            System.out.print("null" + " ");
            return;
        }else {
            System.out.print(root.val + " "); // 有值，输出
        }
        if(root.left == null && root.right == null) return; // 叶子节点，直接返回
        if(root.left != null){
            printDfs(root.left);
        }else{
            System.out.print("null" + " ");
        }
        if(root.right != null){
            printDfs(root.right);
        }else {
            System.out.print("null" + " ");
        }

    }

}
