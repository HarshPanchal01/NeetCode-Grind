# Time Complexity: O(n)
# Space Complexity: O(1)
'''
The time complexity is O(n) overall because of 2 O(n) loops. The space complexity is O(1) assuming we don't
count the res array, but if we do then O(n) as well. I had to watch NeetCode's soln for this, but if u
see my commented out soln, you'll see it's the exact same concept but im using more space, more time, and 
less braincells.
'''

def productsExceptSelf(nums):

    res = [1] * (len(nums))

    prefix, postfix = 1, 1

    # O(n)
    for i in range(len(nums)):

        res[i] = prefix
        prefix *= nums[i]
 
    # O(n)
    for i in range(len(nums) - 1, -1, -1):

        res[i] *= postfix
        postfix *= nums[i]

    return res

    # res = []
    # firstPass = []
    # secondPass = []


    # # O(n^2)
    # for i in range(len(nums)):
    #     if(i < len(nums) - 1):
    #         firstPass.append(prod(nums[i+1::]))
    #     else:
    #         firstPass.append(1)

    # # O(n^2)
    # for i in range(len(nums), -1, -1):
    #     if(i > 0):
    #         secondPass.insert(0, prod(nums[:i]))
    #     else:
    #         secondPass.insert(0, 1)

    # print(firstPass, secondPass)
    # for i in range(len(firstPass)):
    #     res.append(firstPass[i] * secondPass[i])

    # return res

print(productsExceptSelf([-1,0,1,2,3]))


