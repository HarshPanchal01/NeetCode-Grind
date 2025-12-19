# Time Complexity: O(logn)
# Space Complexity: O(1)
'''
Time complexity is O(logn) because once again, we used binary search for this. Space is constant because no extra data structures. Had to read the soln
for this one too man.
'''

def search(nums, target):

    left, right = 0, len(nums) - 1

    while(left <= right):

        mid = left + (right - left)//2

        if(nums[mid] == target):
            return mid
        elif(right == left):
            break
        
        # if(nums[mid] > target):

        #     if(nums[left] > target):
        #         left = mid + 1
        #     else:
        #         right = mid - 1
        # else:
        #     left = mid + 1
        
        # So I think we're establishing 2 ranges, 
        # one from left to mid, and another from mid to right
        if(nums[left] <= nums[mid]):

            # Here if the target isn't in the left range
            if(target > nums[mid] or target < nums[left]):
                
                # Then leave the left range
                left = mid + 1
            else:
                # Else enter the left range
                right = mid - 1
        else:
            # Now we're on the right range
            if(target < nums[mid] or target > nums[right]):
                right = mid - 1
            else:
                left = mid + 1
    
    return -1

print(search([3,4,5,6,1,2], 1))
print(search([3,4,5,6,1,2], 3))
print(search([3,4,5,6,1,2], 0))
print(search([3], 3))
print(search([5,1,3], 5))












