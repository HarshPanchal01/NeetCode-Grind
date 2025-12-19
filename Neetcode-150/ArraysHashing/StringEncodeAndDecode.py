# Time Complexity: O(n)
# Space Complexity: O(n)
'''
The time complexity is O(n) since we're looping through every word in the given list strs. The space complexity is O(n) as well since the "s" variable 
increases in size as there are more words in strs. 
'''

def encode(strs):

    # O(n) space since this variable increases in size linearly with the size of strs
    s = ""

    # O(n) for n words in strs
    for word in strs:
        s += word + "%"
    return s

def decode(s):

    # The split function is an O(n) operation
    res = s.split("%")
    res.pop()
    return res


res = encode(["neet","code","love","you"])

print(decode(res))

