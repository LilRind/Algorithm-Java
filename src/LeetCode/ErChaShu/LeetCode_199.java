package LeetCode.ErChaShu;

import LeetCode.ErChaShu.TreeNode.TreeNode;
import LeetCode.LianBiao.ListNode.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
输入: [1,2,3,null,5,null,4]
输出: [1,3,4]

输入: [1,null,3]
输出: [1,3]

输入: []
输出: []
 */

// 灵神题解：dfs，先递归右子树，再递归左子树，当某个深度首次到达时，对应的节点就在右视图中
// 递归应该是最快的
// https://leetcode.cn/problems/binary-tree-right-side-view/solutions/2015061/ru-he-ling-huo-yun-yong-di-gui-lai-kan-s-r1nc/?envType=study-plan-v2&envId=top-100-liked

// 官方题解，dfs，bfs
// https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-100-liked

// 199. 二叉树的右视图
// https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-100-liked
public class LeetCode_199 {
    public static void main(String[] args) {
        // 示例1
        TreeNode a = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(4);
        // 构建节点关系
        a.left = node2;
        a.right = node3;
        node2.right = node4;
        node3.right = node5;

        System.out.println(rightSideView(a).toString());
        // 示例2
        TreeNode b = new TreeNode(1);
        TreeNode node6 = new TreeNode(3);

        b.right = node6;

        System.out.println(rightSideView(b).toString());



    }


    // 第一次做，思路是bfs + 队列优先遍历右子节点，成功了
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>(); // 返回结果
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root); // 加入根节点

        while (!queue.isEmpty()){
            TreeNode rightNode = queue.peek(); // 得到每一层的最右侧节点，不弹出
            res.add(rightNode.val); // 加入到返回结果链表中

            int currentLevelSize = queue.size(); // 每一层的节点个数
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll(); // 弹出每一层的
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return res;
    }

    // 灵神：先递归右子树，再递归左子树，当某个深度首次到达时，对应的节点就在右视图中
    /*
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (depth == ans.size()) { // 这个深度首次遇到
            ans.add(root.val);
        }
        dfs(root.right, depth + 1, ans); // 先递归右子树，保证首次遇到的一定是最右边的节点
        dfs(root.left, depth + 1, ans);
    }
     */


}
