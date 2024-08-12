package CodeTop;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


// 灵神：
// https://leetcode.cn/problems/lru-cache/solutions/2456294/tu-jie-yi-zhang-tu-miao-dong-lrupythonja-czgt/

// LinkedHashMap 实现 LRU。面试中不让用。
// https://blog.csdn.net/m0_56602092/article/details/130427065?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0-130427065-blog-104914473.235^v43^pc_blog_bottom_relevance_base1&spm=1001.2101.3001.4242.1&utm_relevant_index=1

// https://leetcode.cn/problems/lru-cache/description/?envType=study-plan-v2&envId=top-100-liked
// 重点关注
// 146. LRU 缓存
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
public class LeetCode_146 {
    public static void main(String[] args) {
        // 最左为链表首部，最右为链表尾部
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        System.out.println("put(1, 1)" + lRUCache.toString());
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println("put(2, 2)" + lRUCache.toString());
        lRUCache.get(1);    // 返回 1
        System.out.println("get(1)" + lRUCache.toString());
        System.out.println(lRUCache.toString());
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println("put(3, 3)" + lRUCache.toString());
        lRUCache.get(2);    // 返回 -1 (未找到)
        System.out.println("get(2)" + lRUCache.toString());
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println("put(4, 4)" + lRUCache.toString());
        lRUCache.get(1);    // 返回 -1 (未找到)
        System.out.println("get(1)" + lRUCache.toString());
        lRUCache.get(3);    // 返回 3
        System.out.println("get(3)" + lRUCache.toString());
        lRUCache.get(4);    // 返回 4
        System.out.println("get(4)" + lRUCache.toString());
    }
}

// 灵神：
// 构造Node类，包括 k、v，前、后指针，带参构造方法。
// 构造LRUCache类，包括容量、哨兵节点、Map<value, Node>，带参构造方法
// 在LRUCache类中，构造 1. 通过key获取节点的值、2. 通过 key 查询节点、3. 通过 key、value 新增或修改
// 4. 从链表中删除一个节点、5. 将节点 x 置为头节点，即哨兵节点和前头节点之间构造双向链接
class LRUCache {
    private static class Node { // 双向链表节点，负责存取key，value、构建双向链表
        int key, value;
        Node prev, next; // 双向链表，前、后节点
        Node(int k, int v) { // 带参构造方法
            key = k;
            value = v;
        }
    }

    private final int capacity; // 容量
    private final Node dummy = new Node(0, 0); // 哨兵节点
    private final Map<Integer, Node> keyToNode = new HashMap<>(); // Map 保存 <value, Node>

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key) { // 通过key获取节点的值
        Node node = getNode(key); // 调用获取节点方法
        return node != null ? node.value : -1; // 判断节点是否存在，存在返回值
    }

    public void put(int key, int value) { // 通过 key、value 新增或修改
        Node node = getNode(key); // 先通过 key 获取这个节点
        if (node != null) { // 节点存在，是修改操作
            node.value = value; // 更新 value
            return;
        }
        node = new Node(key, value); // 节点不存在，是新增操作，先构造节点
        keyToNode.put(key, node); // 放入 HashMap 中
        pushFront(node); // 将节点置为链表头节点
        // 加入之后，要判断 Map 的大小是否大于容量
        if (keyToNode.size() > capacity) { // 如果 HashMap 实际数量 > 容量
            Node backNode = dummy.prev; // 通过哨兵节点的 prev 指针获取链表中的末尾节点
            keyToNode.remove(backNode.key); // 通过 key 去掉 Map 中的末尾节点
            remove(backNode); // 在链表中去掉末尾节点
        }
    }

    // 通过 key 查询节点。不存在直接返回、存在要再链表中移除再置为头节点，再返回。
    private Node getNode(int key) { // 通过 key 获取节点。节点存在、或不存在
        if (!keyToNode.containsKey(key)) { // 如果 Map 中不存在该节点
            return null;
        }
        Node node = keyToNode.get(key); // 节点存在，从 Map 中获取该节点
        remove(node); // 先移除该节点
        pushFront(node); // 再将该节点放入链表头部
        return node; // 链表操作完之后返回节点
    }

    // 从链表中删除一个节点
    private void remove(Node x) {
        x.prev.next = x.next; // 当前节点 x 的上一个节点的 next 指向 x 的下一个节点
        x.next.prev = x.prev; // 当前节点 x 的下一个节点的 prev 指向 x 的上一个节点
    }

    // 在链表头添加一个节点。x 与 dummy 和 dummy.next 之间构成双向链接
    private void pushFront(Node x) {
        // 先让 x 的前、后指针指向dummy、dummy.next
        x.prev = dummy; // x 的上一个节点是 dummy
        x.next = dummy.next; // x 的下一个节点是 dummy的 next
        // 再让 dummy 的后指针指向 x、dummy.next的前指针指向 x
        x.prev.next = x; // 让 dummy 的 next 指向 x
        x.next.prev = x; // 让 x 的 下一个节点的 prev 指向 x
    }
}

// 笔试可以这样写，快捷方便
/*
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity; // 容量

    public LRUCache(int capacity) {
        // accessOrder来决定按哪种顺序排序，默认无参构造器为false。设置为true，被访问的元素会被移动到链表尾部，put和get等方法都表示访问。
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    // 找不到返回默认值-1
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 当size() > capacity，则淘汰策略开启
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    // 这个可不写
    public void put(int key, int value) {
        super.put(key, value);
    }
}
*/

// 面试时，可以参考这篇文章，leetCode146上官方答案是，哈希 + 手动实现双向链表
// https://www.jianshu.com/p/17593fef9f32
/*

public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

 */