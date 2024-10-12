#Time Complexity: O(n)
#Space Complexity: O(n)
'''
The time complexity is O(n) because at worst, we're looping through all n integers of nums. The 
space complexity is O(n) as well because the size of the hashmap can increase to the size of nums
in the worst case scenario, where every integer in nums is unique and code had to loop through all elements.
This would make the size of the hashmap n-1, assuming there are n integers in nums, but this simply condenses
down to a size of n. 
'''

def twoSum(nums, target):
    
    #O(1)
    if(len(nums) == 2):
        return [0, 1]

    #O(n) space since at worst it will scale to the length of nums
    hashmap = {}

    #O(n) time
    for i in range(len(nums)):

        if((target - nums[i]) in hashmap):
            return [hashmap[(target - nums[i])], i]
        else:
            hashmap[nums[i]] = i

print(twoSum([3,4,5,6], 7))
print(twoSum([3,5,5,6], 11))


