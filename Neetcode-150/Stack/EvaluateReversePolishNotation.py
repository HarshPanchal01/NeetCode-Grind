# Time Complexity: O(n)
# Space Complexity: O(n)
'''
The time complexity is O(n) because we're doing one pass of the tokens array. The space complexity is O(n) because at worst 
case the size of the stack can be the same size as tokens.
'''

class Solution:

    def evalRPN(self, tokens):

        if(len(tokens) == 1):
            return int(tokens[0])
        
        stack = []

        for token in tokens:

            if(token == "*" or token == "/" or token == "+" or token == "-"):

                secondNum = int(stack.pop())
                firstNum = int(stack.pop())
                val = 0

                if(token == "+"):
                    val = firstNum + secondNum
                elif(token == "-"):
                    val = firstNum - secondNum
                elif(token == "*"):
                    val = firstNum * secondNum
                elif(token == "/"):
                    val = int(firstNum / secondNum)
                
                stack.append(val)
            else:
                stack.append(token)

        return stack[0]
