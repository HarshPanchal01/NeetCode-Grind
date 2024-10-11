
def hasDuplicate(nums) -> bool:
     hashmap = {}

     for num in nums:
          if(num not in hashmap):
               hashmap[num] = 0
          else:
               return True
     return False
    
    
print(hasDuplicate([1, 2, 3, 3]))
print(hasDuplicate([1, 2, 3, 4]))