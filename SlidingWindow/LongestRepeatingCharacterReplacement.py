# Time Complexity: O(n)
# Space Complexity: O(m)
'''
I kinda just ripped off this soln from NeetCode, so thought I should document this one. O(n) time because
we're doing one pass of the string. O(m) space because we're using a hashmap that will store m unique 
characters.
'''

def characterReplacement(s, k):
    charCount = {} # To keep track of the count of each char
    res = 0 # The final result
    
    left = 0

    # To keep track of the character with the largest count
    maxChar = 0

    # Loop through the string
    for right in range(len(s)):

        # Increment the count of the current character
        charCount[s[right]] = 1 + charCount.get(s[right], 0)

        # Maybe maxChar in the prev iteration was another letter,
        # see if the current letter has a larger count now
        maxChar = max(maxChar, charCount[s[right]])

        # As long as in the current window(right - left + 1)
        # the number of characters that are not maxChar are greater then k
        # keep replacing
        while (right - left + 1) - maxChar > k:
            charCount[s[left]] -= 1
            left += 1

        # Now compare the previous result with the current window
        res = max(res, right - left + 1)

    return res
    # left = 0
    # sArr = list(s)
    # kay = k
    # longestLen = -1

    # for right in range(len(sArr)):

    #     if(s[right] != s[left]):
    #         if(kay > 0):
    #             kay -= 1
                
    #         else:
    #             kay = k
    #             left = right
        
    #     longestLen = max(longestLen, right - left + 1)
    
    # return longestLen

print(characterReplacement("XYYX", 2))
print(characterReplacement("X", 1))









