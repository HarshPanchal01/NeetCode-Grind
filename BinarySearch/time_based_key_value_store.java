import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class time_based_key_value_store {
    static class TimeMap {
        private HashMap<String, List<Pair>> map;

        private static class Pair {
            int timestamp;
            String value;
    
            Pair(int timestamp, String value) {
                this.timestamp = timestamp;
                this.value = value;
            }
        }
    
        public TimeMap() {
            map = new HashMap<>();
        }
    
        public void set(String key, String value, int timestamp) {
            // Add an entry to the map if the key is new, with an empty list of pairs
            map.putIfAbsent(key, new ArrayList<>());
            // Add the timestamp and value pair to the list associated with the key
            map.get(key).add(new Pair(timestamp, value));
        }
    
        public String get(String key, int timestamp) {
            // Check if the key exists in the map; if not, return an empty string
            if (!map.containsKey(key)) {
                return "";
            }
    
            // Retrieve the list of pairs for the specified key
            List<Pair> pairs = map.get(key);
    
            // Binary search to find the latest timestamp <= given timestamp
            int left = 0, right = pairs.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;  // Find the middle index
                if (pairs.get(mid).timestamp == timestamp) {
                    return pairs.get(mid).value;  // Exact match found
                } 
                else if (pairs.get(mid).timestamp < timestamp) {
                    left = mid + 1;  // Move right if mid timestamp is less than target
                } 
                else {
                    right = mid - 1;  // Move left if mid timestamp is more than target
                }
            }
    
            // If no exact timestamp found, use the largest timestamp <= given timestamp
            return right >= 0 ? pairs.get(right).value : "";
        }
    }
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("alice", "happy", 1);  // store the key "alice" and value "happy" along with timestamp = 1.
        System.out.println(timeMap.get("alice", 1));           // return "happy"
        System.out.println(timeMap.get("alice", 2));           // return "happy", there is no value stored for timestamp 2, thus we return the value at timestamp 1.
        timeMap.set("alice", "sad", 3);    // store the key "alice" and value "sad" along with timestamp = 3.
        System.out.println(timeMap.get("alice", 3));           // return "sad"

        // time complexity of set is O(1) and for get is O(log(n)), the space complexity will be O(m * n)
    }
}
