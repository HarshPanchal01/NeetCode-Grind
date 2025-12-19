# Time Complexity: O(n)
# Space Complexity: O(1)
'''
Yep, ignore my incredibly verbose and useless bruteforce soln and replace it with this stupidly 
unintuitive optimal soln. Anyways, the time complexity is O(n) because we're using two pointers unintuitively. 
The space complexity is constant because we're not using any extra data structures. 
'''

def trap(height):

    if not height:
        return 0

    l, r = 0, len(height) - 1
    leftMax, rightMax = height[l], height[r]
    res = 0
    while l < r:
        if leftMax < rightMax:
            l += 1
            leftMax = max(leftMax, height[l])
            res += leftMax - height[l]
        else:
            r -= 1
            rightMax = max(rightMax, height[r])
            res += rightMax - height[r]
    return res

    # left, right = 0, 0
    # maxSum = 0

    # while(left < len(height)):

    #     # Run the right pointer until u reach a higher or equal value
    #     if(height[left] != 0):
            
    #         right = left

    #         # Assuming right doesn't hit the end, once it passes this, it should find the 2nd boundary
    #         right += 1
    #         while(right < len(height)):
    #             if(height[right] == 0):
    #                 right += 1
    #             else:
    #                 break

    #         # If it hits the end and no 2nd boundary is found, no new area can be calculated
    #         if(right >= len(height)):
    #             break
            
    #         # If they're side-by-side
    #         if(right == left + 1):
    #             left = right
    #             continue
                

    #         # Now that you have both boundaries, compare, and find current max sum
    #         currMaxSum = 0
    #         if(height[left] > height[right]):
    #             currMaxSum = height[right] * (right - (left + 1))
    #         else:
    #             currMaxSum = height[left] * (right - (left + 1))

    #         # Now begin the two-pointer part
    #         tempLeft = left + 1
    #         tempRight = right - 1
    #         while(tempLeft <= tempRight):

    #             if(tempLeft != tempRight):
    #                 currMaxSum -= (height[tempLeft] + height[tempRight])
    #             else:
    #                 currMaxSum -= height[tempLeft]
    #             tempLeft += 1
    #             tempRight -= 1
            
    #         maxSum += currMaxSum

    #         left = right
    #     else:
    #         left += 1
    #         right += 1

    # return maxSum

print(trap([0,1,0,2,1,0,1,3,2,1,2,1]))
            














