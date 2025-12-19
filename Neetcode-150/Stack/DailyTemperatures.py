# Time Complexity: O(n)
# Space Complexity: O(n)
'''
The time complexity is O(n) because we're doing one pass of the temperatures array. The space complexity is also
O(n) becasue the stack will have at worst n elements, if n is the number of elements in the temperatures array. 
'''

def dailyTemperatures(temperatures):

    res = [0] * len(temperatures)
    stack = []

    # O(n)
    for i in range(len(temperatures)):

        while(stack and temperatures[i] > temperatures[stack[-1]]):
            index = stack.pop()
            res[index] = i - index
        
        stack.append(i)

    return res

print(dailyTemperatures([22,21,20]))
print(dailyTemperatures([34,27,33,25,36]))

            


















    
            