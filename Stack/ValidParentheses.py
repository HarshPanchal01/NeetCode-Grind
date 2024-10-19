# Time Complexity: O(n)
# Space Complexity: O(n)
'''
The time complexity is O(n) because we're doing one pass of the string s. The .append() and .pop() fn's operate at 
O(1) time. The space complexity is O(n) as well because at worst case scenario, the stack will have the same length
as the string s. 
'''

def isValid(s):

    # O(n) space(not including the hashmap)
    stack = []
    hashmap = {"(" : ")", "{" : "}", "[" : "]"}

    # O(n)
    for bracket in s:
        if(bracket != ")" and bracket != "}" and bracket != "]"):
            stack.append(bracket)
        else:
            if(len(stack) == 0 or hashmap[stack.pop()] != bracket):
                return False
    
    return True if len(stack) == 0 else False


print(isValid("[({"))




