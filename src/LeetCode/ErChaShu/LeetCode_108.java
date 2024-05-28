package LeetCode.ErChaShu;

import LeetCode.ErChaShu.TreeNode.TreeNode;

import java.util.Random;

import static LeetCode.ErChaShu.TreeNode.TreeNode.printDfs;

// 重点关注
// 108. 将有序数组转换为二叉搜索树
public class LeetCode_108 {
    static Random rand = new Random();

    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = -10;
        nums[1] = -3;
        nums[2] = 0;
        nums[3] = 5;
        nums[4] = 9;
        // 因为选择任意一个中间位置数字作为根节点，所以会有不同答案
        printDfs(sortedArrayToBST(nums));
    }

    // 返回已经转换好的平衡二叉搜索树的根节点
    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
//        int mid = (left + right) / 2;

//        // 总是选择中间位置右边的数字作为根节点
//        int mid = (left + right + 1) / 2;

        // 选择任意一个中间位置数字作为根节点
        int mid = (left + right + rand.nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

}
