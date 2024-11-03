# Time Complexity: O(logn)
# Space Complexity: O(1)
'''
Wow its like midnight rn and I still kinda got the soln to the problem. I saw this problem a long time ago so I remember remnants of the gist of the soln.
Though yeah, the time complexity is O(logn) coz we're using binary search, and the space complexity is O(1) coz we're not using any extra data structures. 
'''

def findMin(nums):

    left, right = 0, len(nums) - 1

    while(left <= right):

        mid = left + (right - left)//2

        if(nums[right] < nums[mid]):
            left = mid + 1
        elif(nums[right] >= nums[mid]):
            right = mid - 1

        if(mid-1 > 0 and nums[mid-1] > nums[mid]):
            return nums[mid]
        elif(mid+1 < len(nums) and nums[mid+1] < nums[mid]):
            return nums[mid+1]
        elif(mid == 0):
            # This took me a while, if left and right are the same, then we've
            # reached the target
            return nums[mid]
        











