package LeetCode.ErChaShu;

import LeetCode.ErChaShu.TreeNode.TreeNode;

// K神：递归法、辅助栈（或队列）
// https://leetcode.cn/problems/invert-binary-tree/solutions/2361621/226-fan-zhuan-er-cha-shu-fen-zhi-qing-xi-tqlf/?envType=study-plan-v2&envId=top-100-liked

// 226. 翻转二叉树
public class LeetCode_226 {
    public static void main(String[] args) {

    }

    // 第一次解出，递归交换左右节点。还可以优化，K神的递归法就是优化过后的
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        invertTree(root.left); // 递归交换左子树
        invertTree(root.right); // 递归交换右子树
        // 交换节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    // K神：方法一：递归法、方法二：辅助栈（或队列）
    /*
    // 方法一：递归法。非常简洁
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
    // 方法二：辅助栈（或队列）
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>() {{ add(root); }};
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
     */

    // 官方：方法一：递归
    /*
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
     */


    // 之前做的
    /*
    public TreeNode invertTree(TreeNode root) {
		if(root==null) {
			return null;
		}
		//将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			//每次都从队列中拿一个节点，并交换这个节点的左右子树
			TreeNode tmp = queue.poll();
			TreeNode left = tmp.left;
			tmp.left = tmp.right;
			tmp.right = left;
			//如果当前节点的左子树不为空，则放入队列等待后续处理
			if(tmp.left!=null) {
				queue.add(tmp.left);
			}
			//如果当前节点的右子树不为空，则放入队列等待后续处理
			if(tmp.right!=null) {
				queue.add(tmp.right);
			}

		}
		//返回处理完的根节点
		return root;
	}
     */

}
