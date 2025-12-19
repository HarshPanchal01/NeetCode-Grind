import java.util.LinkedHashMap;
import java.util.Map;

public class LRU_cache {
    static class LRUCache {
        private final Map<Integer, Integer> cache;
        private final int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > LRUCache.this.capacity;
                }
            };
        }

        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 10);  // cache: {1=10}
        System.out.println(lRUCache.get(1));      // return 10
        lRUCache.put(2, 20);  // cache: {1=10, 2=20}
        lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
        System.out.println(lRUCache.get(2));      // returns 20 
        System.out.println(lRUCache.get(1));      // return -1 (not found)

        // time complexity is O(1) for put and get and space complexity is O(n) due to map
    }
}