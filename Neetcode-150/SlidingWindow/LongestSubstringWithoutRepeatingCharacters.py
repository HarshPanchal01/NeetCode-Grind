# Time Complexity: O(n)
# Space Complexity: O(1)
'''
Had to look at the soln for this one lol, mine kept failing at the test case = "au". Anwyays,
same thing for time complexity, we're just doing one pass at most because of the for loop. O(1) space
because no extra data structure.
'''

def lengthOfLongestSubstring(s):

    if(len(s) == 0):
        return 0
    if(len(s) == 1):
        return 1

    hashMap = {}
    longestLen = 0
    left = 0

    for right in range(len(s)):

        if(s[right] in hashMap):
            left = max(hashMap[s[right]] + 1, left)
        longestLen = max(longestLen, right - left + 1)
        hashMap[s[right]] = right

    return longestLen

print(lengthOfLongestSubstring("au"))
print(lengthOfLongestSubstring("zxyzxyzxyz"))
print(lengthOfLongestSubstring("zzzzz"))
print(lengthOfLongestSubstring("x"))
print(lengthOfLongestSubstring(""))
    

















