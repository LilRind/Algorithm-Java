package LeetCode.ErChaShu;

import LeetCode.ErChaShu.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 官方：递归、迭代(栈实现)、Morris 中序遍历(空间复杂度O(1))
// https://leetcode.cn/problems/binary-tree-inorder-traversal/solutions/412886/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/?envType=study-plan-v2&envId=top-100-liked

// Morris（莫里斯）遍历
// https://leetcode.cn/problems/binary-tree-inorder-traversal/solutions/96765/dong-hua-yan-shi-94-er-cha-shu-de-zhong-xu-bian-li/?envType=study-plan-v2&envId=top-100-liked

// 94. 二叉树的中序遍历
public class LeetCode_94 {
    static private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

    }

    // 第一次解出，类似于官方dfs写法，和之前写的解法有点出入，差异在于list可以直接返回，
    public static List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return list;
    }

    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    // 之前的解法，list可以直接返回
    /*
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root == null){
            return list;
        }

        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
     */

    // 方法二：迭代
    /*
        public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

     */

    // Morris（莫里斯）遍历
    /*
    	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		TreeNode pre = null;
		while(root!=null) {
			//如果左节点不为空，就将当前节点连带右子树全部挂到
			//左节点的最右子树下面
			if(root.left!=null) {
				pre = root.left;
				while(pre.right!=null) {
					pre = pre.right;
				}
				pre.right = root;
				//将root指向root的left
				TreeNode tmp = root;
				root = root.left;
				tmp.left = null;
			//左子树为空，则打印这个节点，并向右边遍历
			} else {
				res.add(root.val);
				root = root.right;
			}
		}
		return res;
	}
     */

}
