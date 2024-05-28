package LeetCode.LianBiao;

import java.util.LinkedHashMap;
import java.util.Map;

// 146. LRU 缓存
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

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
