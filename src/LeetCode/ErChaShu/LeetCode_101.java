package LeetCode.ErChaShu;

import LeetCode.ErChaShu.TreeNode.TreeNode;

/*
输入：root = [1,2,2,3,4,4,3]
输出：true

输入：root = [1,2,2,null,3,null,3]
输出：false
 */

// 所有解法差别不大
// K神：递归
// https://leetcode.cn/problems/symmetric-tree/solutions/2361627/101-dui-cheng-er-cha-shu-fen-zhi-qing-xi-8oba/?envType=study-plan-v2&envId=top-100-liked

// 王：队列、递归
// https://leetcode.cn/problems/symmetric-tree/solutions/46560/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/?envType=study-plan-v2&envId=top-100-liked

// 官方：递归、队列
// https://leetcode.cn/problems/symmetric-tree/solutions/268109/dui-cheng-er-cha-shu-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked

// 重点关注
// 101. 对称二叉树
public class LeetCode_101 {
    public static void main(String[] args) {
        // 示例
        TreeNode a = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        //
        a.left = node2;
        a.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(isSymmetric(a));
    }


    // 第一次未解出，详细思考下如何判断轴对称关系
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return LR(root.left, root.right);
    }
    public static boolean LR(TreeNode left, TreeNode right){
        // 左右节点同时为空，则对称
        if (left == null && right == null) {
            return true;
        }
        // 左、右节点一个为空，或者都存在但值不相同
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        // 判断左、右子树是否为轴对称，
        return LR(left.left, right.right) && LR(left.right, right.left);
    }

}




    // K神：递归，掌握
    /*
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
     */

    // 官方：递归
    /*
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
     */

    // 队列实现，只用一个方法
    /*
	public boolean isSymmetric(TreeNode root) {
		if(root==null || (root.left==null && root.right==null)) {
			return true;
		}
		//用队列保存节点
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		//将根节点的左右孩子放到队列中
		queue.add(root.left);
		queue.add(root.right);
		while(queue.size()>0) {
			//从队列中取出两个节点，再比较这两个节点
			TreeNode left = queue.removeFirst();
			TreeNode right = queue.removeFirst();
			//如果两个节点都为空就继续循环，两者有一个为空就返回false
			if(left==null && right==null) {
				continue;
			}
			if(left==null || right==null || left.val != right.val) {
				return false;
			}
			//将左节点的左孩子， 右节点的右孩子放入队列
			queue.add(left.left);
			queue.add(right.right);
			//将左节点的右孩子，右节点的左孩子放入队列
			queue.add(left.right);
			queue.add(right.left);
		}

		return true;
	}

     */


// 之前写的
/*
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // 空树视为对称
        }
        return isSymmetricHelper(root.left, root.right);
    }
    private boolean isSymmetricHelper(TreeNode leftNode, TreeNode rightNode) {
        // 左右节点同时为空，则对称
        if (leftNode == null && rightNode == null) {
            return true;
        }
        // 左右节点有一个为空或值不相等，则不对称
        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            return false;
        }
        // 经过以上逻辑判断后，说明左、右节点必定存在且相等

        // 递归判断左子节点的左子节点与右子节点的右子节点，以及左子节点的右子节点与右子节点的左子节点
        return isSymmetricHelper(leftNode.left, rightNode.right) && isSymmetricHelper(leftNode.right, rightNode.left);
    }

 */