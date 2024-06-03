package LeetCode.ErChaShu;

import LeetCode.ErChaShu.TreeNode.TreeNode;

// K神：递归 + 中序遍历
// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solutions/2361685/230-er-cha-sou-suo-shu-zhong-di-k-xiao-d-n3he/?envType=study-plan-v2&envId=top-100-liked

// 官方：栈 + 中序遍历
// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solutions/1050055/er-cha-sou-suo-shu-zhong-di-kxiao-de-yua-8o07/?envType=study-plan-v2&envId=top-100-liked

// 三叶：树的遍历 + 排序
// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solutions/1051120/gong-shui-san-xie-yi-ti-san-jie-pai-xu-y-8uah/?envType=study-plan-v2&envId=top-100-liked

// 掌握：递归 + 中序遍历
// 重点关注
// 230. 二叉搜索树中第K小的元素
public class LeetCode_230 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);

        a.left = node2;
        a.right = node3;
        node2.right = node4;
        int k1 = 1;
        System.out.println(kthSmallest(a, k1));

    }

    // 第二次写
    static int res;
    static int k;

    public static int kthSmallest(TreeNode root, int kVal) {
        k = kVal;
        dfs(root);
        return res;
    }
    public static void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.right);
    }


    // 掌握。第一次未解出。注意，这是在LeetCode官方环境下
    /*
     int res, k;
     void dfs(TreeNode root) {
         if (root == null) return;
         dfs(root.left);
         if (k == 0) return;
         if (--k == 0) res = root.val;
         dfs(root.right);
     }
     public int kthSmallest(TreeNode root, int k) {
         this.k = k;
         dfs(root);
         return res;
     }
     */

    // 栈 + 中序遍历
    /*
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
     */


    // 树的遍历 + 排序（3ms）
    /*
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        Collections.sort(list);
        return list.get(k - 1);
    }
    void dfs(TreeNode root) {
        if (root == null) return ;
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
     */


}
