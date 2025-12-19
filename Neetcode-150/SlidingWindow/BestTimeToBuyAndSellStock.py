# Time Complexity: O(n)
# Space Complexity: O(1)
'''
Welp this one also took some thought process loool. Anyways, O(n) time because we're doing, at most, one pass
of the array. O(1) space because we're not using any extra data structures. 
'''

def maxProfit(prices):
    
    maxProfit = 0
    left, right = 0, 1

    while(right < len(prices)):

        profit = prices[right] - prices[left]
        maxProfit = max(profit, maxProfit)

        if(profit < 0):
            left += 1
        else:
            right += 1

    return maxProfit



print(maxProfit([7,1,5,3,6,4]))
































