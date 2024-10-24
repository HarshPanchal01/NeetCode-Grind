# Time Complexity: O(nlogn)
# Space Complexity: O(n)
'''
yeah fuck htis problem too. I just did whatever and watched the soln lol, but the carMap and the stack will always 
increase linearly even though I had to use 2 extra data structures(regretably). The time complexity will be O(n)
because we're sorting the position array.
'''

def carFleet(target, position, speed):

    
    carMap = {}

    for i in range(len(position)):
        carMap[position[i]] = speed[i]


    stack = []

    for pos in sorted(position, reverse=True):
        stack.append((target - pos) / carMap[pos])
        if(len(stack) >= 2 and stack[-1] <= stack[-2]):
            stack.pop()
        print(stack)

    return len(stack)

print(carFleet(12, [1,4], [3,2]))

        
        




















