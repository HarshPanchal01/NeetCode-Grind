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
