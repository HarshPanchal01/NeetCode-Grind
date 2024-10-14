# Time Complexity: O(nlogn) 
# Space Complexity: O(n)
'''
Time complexity is O(nlogn) because of the sorting. Space complexity is O(n) because the hashmap and array both increase in size, and in worst case, the same size as nums.
Though this isn't the most optimal solution, the most optimal solution uses whats called, Bucket Sort. It will be shown below:

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}
        freq = [[] for i in range(len(nums) + 1)]  <--- This is the main thing of the whole bucket sorting algorithm

        for num in nums:
            count[num] = 1 + count.get(num, 0) <--- Do everything normally
        for num, cnt in count.items():
            freq[cnt].append(num) <--- This time assign the numbers with the highest to lowest frequencies to the sub-lists starting at the end of freq array
        
        res = []
        for i in range(len(freq) - 1, 0, -1): <--- Now start at the end of freq array and go backwards, because the sub-lists at the end have the nums with highest frequency
            for num in freq[i]:
                res.append(num)
                if len(res) == k: <--- Keep looping until you get the top k frequent numbers, then just return
                    return res
'''


def topKFrequent(nums, k):

    hashmap = {}
    array = []
    res = []

    # O(n)
    for num in nums:
        if(num in hashmap):
            hashmap[num] += 1
        else:
            hashmap[num] = 1
    
    # O(n)
    for num, count in hashmap.items():
        array.append([count, num])
    
    # O(nlogn)
    array = sorted(array)

    # O(k)
    while len(res) < k:
        res.append(array.pop()[1])

    return res

print(topKFrequent([1,2,2,3,3,3], 2))
print(topKFrequent([7,7], 1))















