# Time Complexity: O(2^n)
# Space Complexity: O(n)
'''
Yeah so I kinda just copy-pasted Neetcode's solution haha T-T. Gave up after trying for a long time, didn't 
think it would be worth so much time for one problem. Though anyways, time complexity for backtracking algos 
depends on how many choices you have. Here we have 2 choices, opening or closing, so the time complexity is "2"^n or
just O(2^n). The stack, at worst case, will increase to have the same number of parantheses as given, so if there are n
pairs of parantheses, the length of the stack will be double that(to account for opening/closing brackets individually).
This will reduce from O(2n) -> O(n). 
'''

def generateParenthesis(n):
        stack = []
        res = []

        # Backtracking function
        def backtrack(openN, closedN):
            if openN == closedN == n:
                res.append("".join(stack))
                return

            # Don't add open parantheses if you already exceed the limit 
            if openN < n:
                stack.append("(")
                backtrack(openN + 1, closedN)
                stack.pop()

            # If you have more closed then open parantheses then it wont be valid
            # Ex. ()) <-- In this example, where's the corresponding open bracket for the 2nd closing bracket?
            if closedN < openN:
                stack.append(")")
                backtrack(openN, closedN + 1)
                stack.pop()
        # We gonna start with no open/closed brackets in the beginning
        # However, in the first iteration choose the opening bracket first, obviously
        backtrack(0, 0)
        return res