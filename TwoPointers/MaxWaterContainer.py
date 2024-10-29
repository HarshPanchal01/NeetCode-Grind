# Time Complexity: O(n)
# Space Complexity: O(1)
'''
This one came acc pretty easily to me lol, no need to see the solns. The time complexity is O(n) because we're
doing a single half-pass of the array, since the while loop will break once the left and right pointers overtake 
each other. The space complexity is constant coz we're not using any other extra data structures.  
'''

def maxArea(heights):
    left, right = 0, len(heights) - 1
    res = 0

    # O(n)
    while(left < right):

        if(heights[left] < heights[right]):
            res = max(res, heights[left] * (right - left))
            left += 1
        elif(heights[right] < heights[left]):
            res = max(res, heights[right] * (right - left))
            right -= 1
        else:
            res = max(res, heights[left] * (right - left))
            left, right = left + 1, right - 1
    
    return res

print(maxArea([1,7,2,5,4,7,3,6]))
print(maxArea([2,2,2]))
print(maxArea([0,1]))




















