# Time Complexity: O(n^2)
# Space Complexity: O(1)
'''
Had to watch Neetcode's soln to figure out I needed another nested while loop inside the else as well. Otherwise it wasnt that bad of a problem? The overall soln is O(n^2) because for each 
number in the array we're doing one O(n) pass. Space complexity is O(1) coz we're not using any external data structures, assuming we dont count res as one. Decided to write more comments for this
soln to confirm my understanding, because I was feeling a bit iffy about it as well. 
'''

def threeSum(nums):

    left, right = 0, len(nums)-1
    nums.sort()
    res = []


    for i in range(len(nums)):

        # If you've reached the point where the num is > 0
        # then theres no more reason to keep iterating
        # since you'll only get positive numbers from here on that will
        # never add up to 0
        if(nums[i] > 0):
            break
        
        # If you're looking at the same number as the previous iteration then just move
        if(i > 0 and nums[i] == nums[i-1]):
            continue
        
        left, right = i+1, len(nums)-1

        while(left < right):
            
            # We wanna make sure we're not looking at the same number as nums[i]
            # It must be distinct
            if(left < len(nums) and left == i):
                left += 1
            elif(right > 0 and right == i):
                right -= 1

            
            if(nums[i] + nums[left] + nums[right] < 0):
                left += 1
            elif(nums[i] + nums[left] + nums[right] > 0):
                right -= 1
            else:

                #If we've found the ideal numbers then append em
                res.append([nums[i], nums[left], nums[right]])
                left += 1
                right -= 1

                # In order to avoid any further duplicate solns 
                while nums[left] == nums[left - 1] and left < right:
                        left += 1

    return res

print(threeSum([-1,0,1,2,-1,-4]))
print(threeSum([0,0,0]))
print(threeSum([0,1,1]))
print(threeSum([-1,0,1,2,-1,-4]))











