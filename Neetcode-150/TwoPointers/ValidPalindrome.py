# Time Complexity: O(n)
# Space Complexity: O(1)
'''
FINALLY, a fucking breather. I hate that Stack portion of Neetcode's roadmap. Anyways, the time complexity is O(n)
because you're looping through half the array at worst, which is O(n/2) but reduces down to O(n) for large input values.
The space complexity is constant because we're not using any extra data structures. 
'''

def isPalindrome(s):
    
    left, right = 0, len(s)-1
    
    # O(n)
    while(left < right):

        # Both O(1)
        if(left < len(s) and not s[left].isalnum()):
            left += 1
            continue
        if(right > 0 and not s[right].isalnum()):
            right -= 1
            continue

        # O(1)
        if(left > right):
            break
        
        # O(1)
        if(s[left].lower() != s[right].lower()):
            return False

        left += 1
        right -= 1
        
    return True

print(isPalindrome("Madam, in Eden, I'm Adam"))
