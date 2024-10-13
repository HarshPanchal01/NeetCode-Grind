# Time Complexity: O(n * mlog(m))
# Space Complexity: O(m * n)
'''
The time complexity was relatively simple since we're iterating through all n strings in the array.
However, for each iteration we're also sorting the word which is an mlog(m) operation(size of word is m), so
then the actual time complexity of the entire algorithm is O(n * mlog(m)). The space complexity could be O(m * n),
because in the same worst case scenario there are m keys in the dictionary and each word can have up to n characters
'''

def groupAnagrams(strs):

    hashmap = {}

    # O(n)
    for word in strs:
        
        # O(mlog(m))
        sortedWord = "".join(sorted(word))

        if(sortedWord not in hashmap):
            hashmap[sortedWord] = [word]
        else:
            hashmap[sortedWord].append(word)

    return list(hashmap.values())

print(groupAnagrams(["act","pots","tops","cat","stop","hat"]))













