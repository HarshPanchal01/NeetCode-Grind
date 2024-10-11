#Time/Space Complexity
'''
Assuming there are n integers in the array, then the time complexity should be O(n), 
since we are iterating through n integers in the for loop. 
The space complexity should be O(n) as well, since we are using 
a hashmap which takes up at most n integers.
'''

def hasDuplicate(nums) -> bool:

     # Create a hashmap to store each number in the array
     hashmap = {}

     for num in nums:

          #If the number isn't in the hashmap, then that means it
          #hasn't been seen before, then just go ahead and add it to the hashmap
          if(num not in hashmap):
               hashmap[num] = 0
          else:
               return True
     return False
    
print(hasDuplicate([1, 2, 3, 3]))
print(hasDuplicate([1, 2, 3, 4]))