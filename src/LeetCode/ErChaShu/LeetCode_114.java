package LeetCode.ErChaShu;

import LeetCode.ErChaShu.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static LeetCode.ErChaShu.TreeNode.TreeNode.printDfs;
import static LeetCode.LianBiao.ListNode.Node.printNodes;

// 解法 1-3
// https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solutions/17274/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/?envType=study-plan-v2&envId=top-100-liked

// 官方解法 1-4
// https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solutions/356853/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/?envType=study-plan-v2&envId=top-100-liked

// 重点关注
public class LeetCode_114 {
    public static void main(String[] args) {
        // 示例1：
        TreeNode a = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        // 构造关系
        a.left = node2;
        a.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        //
        flatten(a);
        printDfs(a);
        // 输出空格行
        System.out.println();
        // 示例2
        TreeNode b = null;

        flatten(b);
        printDfs(b);
    }

    // 第二次未解出。递归前序遍历 + List修改链表连接
    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList();
        pre(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode tempMid = list.get(i-1), tempL = list.get(i);
            tempMid.right = tempL;
            tempMid.left = null;
        }

    }

    public static void pre(TreeNode root, List<TreeNode> list){
        if(root == null) return;
        list.add(root);
        pre(root.left, list);
        pre(root.right, list);
    }


    // 官方方法一：递归前序遍历，掌握
    /*
    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list); // 前序遍历得到前序List
        int size = list.size();
        // 其中 right 子指针指向链表中下一个结点，而左子指针始终为 null
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i); // 获得前驱节点
            prev.left = null;
            prev.right = curr;
        }
    }
    // 前序遍历，得到前序List
    public static void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    /*



    // 官方方法一：迭代前序遍历，即栈实现前序遍历
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }
    // 方法二：前序遍历和展开同步进行
        public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            TreeNode left = curr.left, right = curr.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = curr;
        }
    }

    // 方法三：寻找前驱节点，与解法1类似，可以掌握
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

}

     */

    // 解法1：寻找前驱节点，自顶向下
    /*
    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }
     */

    // 解法2：自底向上，后序遍历
    /*
    public void flatten(TreeNode root) {
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur); // 添加根节点
                cur = cur.right; // 递归添加右节点
            }
            cur = toVisit.peek(); // 已经访问到最右的节点了
            // 在不存在左节点或者右节点已经访问过的情况下，访问根节点
            if (cur.left == null || cur.left == pre) {
                toVisit.pop();
                // 修改的地方
                cur.right = pre;
                cur.left = null;
                // 修改的地方
                pre = cur;
                cur = null;
            } else {
                cur = cur.left; // 左节点还没有访问过就先访问左节点
            }
        }
    }
    */


    // 第一次做，有错误
    /*
    public TreeNode mySorted (TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }

        TreeNode tempL = root.left; // 记录原左节点，即左子树展开链表头部节点
        TreeNode tempR = root.right; // 保存右节点，即右子树展开链表头部节点
        TreeNode endR = sorted(root.right); // 右子树展开为链表
        TreeNode endL = sorted(root.left); // 得到左子树尾节点，左子树展开为链表

        root.left = null;
        endL.right = tempR;
        root.right = tempL;

        return endR;
    }
     */

}
