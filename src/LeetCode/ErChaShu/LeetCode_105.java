package LeetCode.ErChaShu;

import LeetCode.ErChaShu.TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static LeetCode.ErChaShu.TreeNode.TreeNode.printDfs;

// 重点关注
// 105. 从前序与中序遍历序列构造二叉树
public class LeetCode_105 {
    public static void main(String[] args) {
        // 示例1
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};

        printDfs(buildTree(pre, in));

    }


    // 第二次未解出。分治，掌握
    static HashMap<Integer, Integer> dic = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) // 保存中序列表中节点的索引
            dic.put(inorder[i], i);
        return recur(preorder, 0, 0, inorder.length - 1);
    }
    // （节点在前序列表中的索引，中序列表左边界，中序列表右边界）
    static TreeNode recur(int[] preorder, int root, int left, int right) {
        if (left > right) return null;                          // 已经越过叶节点，递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        // 前序列表中的节点在中序列表中的索引
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(preorder, root + 1, left, i - 1);              // 开启左子树递归
        // 右子树根节点的前序索引为 `i - left + root + 1`
        // `i - left + root + 1` 含义为 `根节点索引 + 左子树长度(i - left) + 1`
        node.right = recur(preorder, root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

    // K神，分治，掌握
    /*
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    // 节点在前序列表中的索引，中序列表左边界，中序列表有边界
    TreeNode recur(int root, int left, int right) {
        if (left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        // 前序列表中的节点在中序列表中的索引
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        // 右子树根节点的前序索引为 `i - left + root + 1`
        // `i - left + root + 1` 含义为 `根节点索引 + 左子树长度(i - left) + 1`
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }
     */

    // 这个方法是 StefanPochmann 大神的方法，如果能理解更好
    /*
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder,  inorder, (long)Integer.MAX_VALUE + 1);
    }
    int pre = 0;
    int in = 0;
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, long stop) {
        //到达末尾返回 null
        if(pre == preorder.length){
            return null;
        }
        //到达停止点返回 null
        //当前停止点已经用了，in 后移
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int root_val = preorder[pre++];
        TreeNode root = new TreeNode(root_val);
        //左子树的停止点是当前的根节点
        root.left = buildTreeHelper(preorder,  inorder, root_val);
        //右子树的停止点是当前树的停止点
        root.right = buildTreeHelper(preorder, inorder, stop);
        return root;
    }
     */


    // 官方方法一：递归、直观
    /*
    private static Map<Integer, Integer> indexMap;

    public static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    */

    // 方法二：迭代
    /*
        public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
     */

    // 第一次未解出
    /*
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode dummyNode = new TreeNode(); // 虚拟节点

        for(int i = 0; i < preorder.length; i++){
            int j = i;
            TreeNode temp = null;
            if(preorder[i] == inorder[j]){ // 没有左节点
                temp = new TreeNode(preorder[i]);
            }else {
                // 找到中节点在中序遍历序列中的位置
                while(preorder[i] != inorder[j] && j < inorder.length - 1){
                    j++;
                }
                temp = new TreeNode(preorder[i]);
                TreeNode tempL = new TreeNode(preorder[--j]);
                temp.left = tempL;
            }
            if(i == 0){
                dummyNode = temp; // 记录二叉树的根节点
            }
        }
        return dummyNode;
    }
    */


}
