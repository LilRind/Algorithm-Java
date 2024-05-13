package tme.bishi0418.LianXi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 19:00 -
// https://blog.csdn.net/Qmtdearu/article/details/137965522
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class L2 {
    public static TreeNode createBalancedTree(int n) {
        if (n == 0) return null;
        TreeNode root = new TreeNode(1 << n);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int level = n; level > 0; level--) { // 控制层数
            int size = queue.size();
            for (int i = 0; i < size; i++) { // 控制每一层，
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                node.left = new TreeNode(1 << (level - 1));
                node.right = new TreeNode(1 << (level - 1));
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n [1,14]
        createBalancedTree(n);
    }
}


//public class L2 {
//    public static void createBalancedTree(int n) {
//        if (n == 1){
//            System.out.println(1);
//        }
//        int sum = (int) Math.pow(2, n-1);
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(new TreeNode(sum));
//        int depth = 1;
//        while (!q.isEmpty()){
//            int nodeNum = q.size();
//            while (nodeNum-- > 0){
//                TreeNode tem = q.poll();
//                System.out.print(tem.val + " ");
//                int allNode = (int) Math.pow(2, depth);
//                tem.left = new TreeNode(sum/allNode);
//                tem.right = new TreeNode(sum/allNode);
//                q.offer(tem.left);
//                q.offer(tem.right);
//            }
//            depth++;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // n [1,14]
//        createBalancedTree(n);
//    }
//}
//
