package LeetCode.ErChaShu;

/*
输入：root = [2,1,3]
输出：true

输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。
 */

import LeetCode.ErChaShu.TreeNode.TreeNode;

// 重点关注
// 98. 验证二叉搜索树
public class LeetCode_98 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        a.left = node2;
        a.right = node3;

        TreeNode b = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(4);

        b.left = node4;
        b.right = node5;

        System.out.println(isValidBST(a)); // true
        System.out.println(isValidBST(b)); // false
    }

    // 第二次未解出。
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long low, long up){
        if(root == null){
            return true;
        }
        if(root.val <= low || root.val >= up){
            return false;
        }
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, up);
    }




    // 第一次写
    /*
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 返回左节点是否小于父节点的值，并且右节点是否大于父节点的值，两个都成立就返回true，任何一个不成立返回false
    public static boolean isValidBST(TreeNode node, long lower, long upper) {
        // 节点为空，不判断，返回true
        if (node == null) {
            return true;
        }
        // 节点小于左节点的值，或者节点大于右节点的值，是返回false，提前结束
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        // 返回左节点是否小于父节点的值，并且右节点是否大于左节点的值
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
     */

    // 中序遍历
    /*
        public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
              // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
     */

}
