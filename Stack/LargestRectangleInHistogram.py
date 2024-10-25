# Time Complexity: O(n)
# Space Complexity: O(n)
'''
Don't see at all how this shit is intuitive. I had to copy and paste Neetcode's soln again, but after understanding
the problem, I tried my best to explain it as short and sweet as possible. The time complexity is linear be
'''


def largestRectangleArea(heights):
        maxArea = 0
        stack = []  # pair: (index, height)

        # O(n)
        for i, h in enumerate(heights):

            # Establish the starting index 
            start = i

            # So, as long as the stack isn't empty, and the current height is
            # less then the height at the top of the stack, keep popping
            while stack and stack[-1][1] > h:

                # If indeed the current height is less then the height at the top
                # of the stack, then try to find the largest area u can with the height
                # at the top of the stack.
                index, height = stack.pop()
                maxArea = max(maxArea, height * (i - index))
                start = index
            stack.append((start, h))

        # For any remaining elements, find the largest area and see if u can find a greater one.
        # Keep in mind that for these elements, they're all able to extend all the way to the right
        # of the histogram, thats why the upper bound of the area calculation is the length of the heights array
        for i, h in stack:
            maxArea = max(maxArea, h * (len(heights) - i))
        return maxArea