# Time Complexity: O(p * logn)
# Space Complexity: O(1)
'''
Yeah, I dont think im cut out for Leetcode man T-T, needed to watch Leetcode soln again smh. The time complexity is O(p * logn) because we're doing logn iterations where 
n is the range from 0 to maximum number of bananas in piles, and p iterations inside the while loop, where p is the number of piles. 
The space complexity is O(1) because we're not using any external data structures.
'''

import math

def minEatingSpeed(piles, h):

    left, right = 0, max(piles)
    res = right

    # O(logn)
    while left <= right:

        mid = left + (right - left)//2
        currTotTime = 0

        # O(p)
        for p in piles:
            currTotTime += math.ceil(p / mid)

        if(currTotTime <= h):
            res = mid
            right = mid - 1 # Now try looking for a smaller rate if possible
        else:
            left = mid + 1 # The rate is too low

    return res



















