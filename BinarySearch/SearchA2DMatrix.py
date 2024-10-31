# Time Complexity: O(log(m * n))
# Space Complexity: O(1)
'''
The hardest part of the problem was figuring out the indices for mid. The time complexity is O(log(m * n)) because 
every iteration we're going through half the entire matrix itself. The space complexity is constant because we're not
using any extra data structures. 
'''

def searchMatrix(matrix, target):

    cols = len(matrix[0])
    rows = len(matrix)

    left, right = 0, (rows * cols) - 1

    while(left <= right):

        mid = left + (right - left)//2

        if(matrix[mid//cols][mid%cols] > target):
            right = mid - 1
        elif(matrix[mid//cols][mid%cols] < target):
            left = mid + 1
        else:
            return True
        
    return False

print(searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3))
print(searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 34))
print(searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 55))



















