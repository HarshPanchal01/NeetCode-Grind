# Time Complexity: O(1) for all functions
# Space Complexity: O(n) for both min stacks
'''
The time complexity for all functions is O(1) as it should be, but the space complexity is O(n) because the size 
of the stacks will increase as more integers are pushed in
'''


class MinStack:

    def __init__(self):
        self.minStack = []
        self.minStack2 = []
        
    def push(self, val: int) -> None:
        
        self.minStack.append(val)

        self.minStack2.append(min(val, self.minStack2[-1] if self.minStack2 else val))

    def pop(self) -> None:
        self.minStack.pop()
        self.minStack2.pop()
        

    def top(self) -> int:
        return self.minStack[-1]
        

    def getMin(self) -> int:
        return self.minStack2[-1]
    

minStack = MinStack()
minStack.push(1)
minStack.push(2)
minStack.push(0)
minStack.getMin()
minStack.pop()
minStack.top()    
minStack.getMin()