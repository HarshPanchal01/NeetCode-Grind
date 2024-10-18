# Time Complexity: O(n)
# Space Complexity: O(n)
'''
The outer for loop runs n times, and the inner for loop runs n times at worst, coz
it can check every element. So O(n) time, and the hashset at worst can have n elements as well so,
O(n) space. 
'''

def longestConsequtive(nums):

        # O(n) space
        hashset = set()
        longestSeq = 0

        # O(n)
        for num in nums:
            hashset.add(num)

        # O(n)
        for num in hashset:
            currSeq = 1
            numBehind = 1
            while(num - numBehind in hashset):
                currSeq += 1
                numBehind += 1
            longestSeq = currSeq if longestSeq < currSeq else longestSeq

        return longestSeq

print(longestConsequtive([2,20,4,10,3,4,5]))
print(longestConsequtive([]))














