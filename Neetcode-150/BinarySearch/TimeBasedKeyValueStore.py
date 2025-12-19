# Time Complexity: O(logn) for get, O(1) for set
# Space Complexity: O(m * n)
'''
The time complexity is O(1) for set(), since we're only appending, and O(logn) for get()
since we're making use of binary search to loop through an array of sub-arrays for a given key 
in the timeMap(otw known as hash map). Space complexity is O(m * n) for m keys in timeMap, and 
n being the length of the array associated with each key. 
'''

class TimeMap:

    def __init__(self):
        self.timeMap = {}   


    def set(self, key: str, value: str, timestamp: int) -> None:

        if key not in self.timeMap:
            self.timeMap[key] = []

        # Initially I set it equal to [value, timestamp] 
        # instead of append, but realized tht we need to keep track of lower timestamp
        # values
        self.timeMap[key].append([value, timestamp])
        

    def get(self, key: str, timestamp: int) -> str:

        res = ""
        keyValues = self.timeMap.get(key, [])
        left, right = 0, len(keyValues) - 1

        while(left <= right):

            mid = left + (right - left)//2

            if(keyValues[mid][1] <= timestamp):
                res = keyValues[mid][0]
                left = mid + 1 # We wanna get the closest value to timestamp
            else:
                right = mid - 1 # Too big, lets look at the lower half of the array

        return res
        
timeMap = TimeMap()
timeMap.set("alice", "happy", 1)  # store the key "alice" and value "happy" along with timestamp = 1.
print(timeMap.get("alice", 1))    # return "happy"
print(timeMap.get("alice", 2))    # return "happy", there is no value stored for timestamp 2, thus we return the value at timestamp 1.
timeMap.set("alice", "sad", 3)    # store the key "alice" and value "sad" along with timestamp = 3.
print(timeMap.get("alice", 3))    # return "sad"















