#Time Complexity: O(n)
#Space Complexity: O(1)
'''
Since at worst, the size of the hashmaps will be the number of English alphabet letters(which is 26 I think lol)
then it's just simplifies down to constant time. We are also using many for loops, but each for loop iterates at worst 
O(n) time, so when approaching larger values of n, this scales down to just O(n). I also realized I could've coded this
much more simply. Instead of having 3 for loops, I could've just had 1 for loop which iterated over index values of either
array s or t, then inside that for loop, both arrays s and t can be accessed alongside their respective hashmaps. 
'''

def isAnagram(s, t) -> bool:

    # O(1)
    if(len(s) != len(t)):
        return False

    # Worst case O(n) space for each hashmap
    sHashmap, tHashmap = {}, {}

    # O(n)
    for char in s:
        if(char in sHashmap):
            sHashmap[char] += 1
        else:
            sHashmap[char] = 1
    
    # O(n)
    for char in t:
        if(char in tHashmap):
            tHashmap[char] += 1
        else:
            tHashmap[char] = 1

    # Worst case O(n) time
    for char, count in sHashmap.items():
        if(char not in tHashmap or count != tHashmap[char]):
            return False
    
    return True


print(isAnagram("racecar", "carrace"))
print(isAnagram("jar", "jam"))