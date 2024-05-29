package LeetCode.ErChaShu;

import LeetCode.ErChaShu.TreeNode.TreeNode;

public class LeetCode_437 {
    public static void main(String[] args) {

    }

    // 方法一：O(N^2)，O(N)，掌握
    /*
    // 表示以节点 root 以及 root以下所有节点为起点满足总和为 targetSum 的路径数目。
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }
    // 表示以节点 root 为起点向下且满足路径总和为 targetSum 的路径数目。
    public int rootSum(TreeNode root, long targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }
        // 左子树和右子树进行递归搜索
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
     */

    // 灵神：前缀和+哈希表
    /*
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        return dfs(root, 0, targetSum, cnt);
    }

    private int dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> cnt) {
        if (node == null) {
            return 0;
        }
        s += node.val;
        int ans = cnt.getOrDefault(s - targetSum, 0);
        cnt.merge(s, 1, Integer::sum);
        ans += dfs(node.left, s, targetSum, cnt);
        ans += dfs(node.right, s, targetSum, cnt);
        cnt.merge(s, -1, Integer::sum); // 恢复现场
        return ans;
    }

     */



    // 第一次未解出，超出时间限制
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        dfsSum(root, targetSum, 0);
        return count;
    }

    public void dfsSum(TreeNode root, int targetSum, int sum) {
        if(root == null){
            return;
        }
        while(root != null){
            sum += root.val;
            if(sum == targetSum){
                count++;
            }
            dfsSum(root.left, targetSum, sum);
            dfsSum(root.right, targetSum, sum);
        }
    }
}
