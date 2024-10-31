# Time Complexity: O(logn)
# Space Complexity: O(1)
'''
My tired ass was confused at this too, made the most stupidest mistakes known to man. I should probably 
do these problems in the morning when im not tired. Anyways, time complexity is O(logn) coz I just 
used binary search which is O(logn) time. Space complexity is constant because I'm not using any 
extra data structures. 
'''

def search(nums, target):

    left, right = 0, len(nums) - 1

    # O(logn)
    while(left <= right):

        mid = left + (right - left)//2

        if(nums[mid] > target):
            right = mid - 1
        elif(nums[mid] < target):
            left = mid + 1
        else:
            return mid
    
    return -1

print(search([-1,0,2,4,6,8], 4))
print(search([-1,0,2,4,6,8], -1))
print(search([-9,-3,0,1,3,6,9], 5))










