package algo.other;


import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author chahe
 * @since 2020-1-15
 */
public class LRUCache {
    private int capacity;
    HashMap<Integer, Integer> store;
    /**最新的在尾 最老的在头部*/
    LinkedList<Integer> nearst;

    private LRUCache(int capacity) {
        this.capacity = capacity;
        this.store = new HashMap<>(capacity);
        this.nearst = new LinkedList<>();
    }

    /**
     * 更新 latest
     * @param key
     * @return
     */
    public int get(int key) {
        int value = store.getOrDefault(key, -1);
        if (value != -1){
            /* 把之前出现的元素干掉 重新插入尾部*/
            nearst.remove((Object)key);
            nearst.add(key);
        }

        return value;
    }

    public void put(int key, int value) {
        Integer result = store.get(key);
        if (result == null){
            if (nearst.size() == capacity){
                int pop = nearst.pop();
                store.remove(pop);
            }

            nearst.remove((Object)key);
            nearst.add(key);
            store.put(key, value);
        }else if (store.getOrDefault(key, -1) != value){
            nearst.remove((Object)key);
            nearst.add(key);
            store.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2);

        cache.get(2);
        cache.put(2, 6);
        cache.get(1);
        cache.put(1, 5);
        cache.put(1, 2);
        cache.get(1);
        cache.get(2);
    }
}
