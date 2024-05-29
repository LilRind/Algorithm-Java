package LeetCode.ErChaShu;

import LeetCode.ErChaShu.TreeNode.TreeNode;

// 官方题解：
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solutions/238552/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/?envType=study-plan-v2&envId=top-100-liked

// 灵神：
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solutions/2023872/fen-lei-tao-lun-luan-ru-ma-yi-ge-shi-pin-2r95/?envType=study-plan-v2&envId=top-100-liked

// K神：返回结果有4种情况，题解中做了详细讨论
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solutions/240096/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/?envType=study-plan-v2&envId=top-100-liked

// 236. 二叉树的最近公共祖先
public class LeetCode_236 {
    public static void main(String[] args) {

    }

    // 灵神：递归
    /*
    求二叉树的最近公共祖先问题，
    拆解成这个节点的左、右子树下是否有p、q节点或者p节点下是否有q或者q节点是否有p，这就是递归终止条件
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 该节点是否是空节点、p、q节点，是就直接返回
        if (root == null || root == p || root == q) { // 当前节点是空节点、p、q节点，直接返回
            return root;
        }
        // 递归左、右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) { // 左、右子树都找到，返回当前节点
            return root;
        }
        // 只有左/右子树找到，返回左/右子树递归结果，返回上一个节点
        return left != null ? left : right;
    }

    // 方法一：递归

    // 方法二：存储父节点

}
