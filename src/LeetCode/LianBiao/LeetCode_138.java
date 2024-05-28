package LeetCode.LianBiao;

import LeetCode.LianBiao.ListNode.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static LeetCode.LianBiao.ListNode.Node.printNodes;

/*
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]

输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]

输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
 */
// 重点关注
public class LeetCode_138 {
    static Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public static void main(String[] args) {
        Node a = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        a.next = node2;
        node2.next = node3;
        node2.random = a;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.random = a;

        printNodes(copyRandomList(a));

    }

    // 方法一：回溯 + 哈希表
    // 返回此节点对应的新节点
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // map不包含这个（旧节点、新节点）
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val); // 创建新节点
            cachedNode.put(head, headNew); // 放入旧节点->新节点
            headNew.next = copyRandomList(head.next); // headNew.next = head.next对应的新节点
            headNew.random = copyRandomList(head.random); // headNew.random = head.random对应的新节点
        }
        return cachedNode.get(head);
    }

    // 两次遍历，Krahets
    class Solution {
        public Node copyRandomList(Node head) {
            if(head == null) return null;
            Node cur = head;
            Map<Node, Node> map = new HashMap<>();
            // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
            while(cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }
            cur = head;
            // 4. 构建新链表的 next 和 random 指向
            while(cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            // 5. 返回新链表的头节点
            return map.get(head);
        }
    }


    // 迭代 + 节点拆分
//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return null;
//        }
//        for (Node node = head; node != null; node = node.next.next) {
//            Node nodeNew = new Node(node.val);
//            nodeNew.next = node.next;
//            node.next = nodeNew;
//        }
//        for (Node node = head; node != null; node = node.next.next) {
//            Node nodeNew = node.next;
//            nodeNew.random = (node.random != null) ? node.random.next : null;
//        }
//        Node headNew = head.next;
//        for (Node node = head; node != null; node = node.next) {
//            Node nodeNew = node.next;
//            node.next = node.next.next;
//            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
//        }
//        return headNew;
//    }


    // 第一次未解出，详细看看官方解答
//    public static Node myCopyRandomList(Node head) {
//        // 存放出现的位置
//        Set<Node> set = new HashSet();
////        Map<Integer, Node> map = new HashMap();
//        int length = 0;
//        // 原节点
//        Node dummyTemp = head;
//
//        // 构造的新节点
//        Node newTemp = new Node();
//        Node newHead = newTemp;
//
//        while(dummyTemp != null){
//            // 创建节点
//            Node newNode = new Node(dummyTemp.val);
//            // 放入Set
//            set.add(newNode);
////            // 放入map
////            map.put(length++, temp.next);
//
//            newTemp.next = newNode;
//
//            newTemp = newTemp.next;
//
//            if(set.contains(newNode.random)){
//
//            }
//        }
//        return null;
//    }
}
