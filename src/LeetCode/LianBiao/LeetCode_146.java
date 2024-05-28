package LeetCode.LianBiao;

import java.util.LinkedHashMap;
import java.util.Map;

// LinkedHashMap 实现 LRU
// https://blog.csdn.net/m0_56602092/article/details/130427065?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0-130427065-blog-104914473.235^v43^pc_blog_bottom_relevance_base1&spm=1001.2101.3001.4242.1&utm_relevant_index=1

// 146. LRU 缓存
// https://leetcode.cn/problems/lru-cache/description/?envType=study-plan-v2&envId=top-100-liked
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

// 笔试可以这样写，快捷方便
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        // accessOrder来决定按哪种顺序排序，默认无参构造器为false。设置为true，被访问的元素会被移动到链表尾部，put和get等方法都表示访问。
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 这个可不写
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

// 面试时，可以参考这篇文章，leetCode146上官方答案是，哈希+手动实现双向链表
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