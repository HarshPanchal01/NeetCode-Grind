# Time Complexity: O(n)
# Space Complexity: O(1)
'''
Today's problem was pretty simple because I kinda remembered remnants of it anyways from before. Though, it clicked hard when I realized I can again just have left/right pointers
and use the fact that the array is sorted to my advantage. O(n) soln because we're doing at most half-pass of the array which is n/2 technically but, it reduces down to n for large
values of input. The space complexity is O(1) coz we're not using any extra data structures. 
'''

def twoSum(numbers, target):

    left, right = 0, len(numbers)-1

    while(left < right):

        currSum = numbers[left] + numbers[right]

        if(currSum > target):
            right -= 1
        elif(currSum < target):
            left += 1
        else:
            return [left+1, right+1]
        

print(twoSum([1,2,3,4], 3))
print(twoSum([-2,1,2,3,4,5], 0))















