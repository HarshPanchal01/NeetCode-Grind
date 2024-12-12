# Time Complexity: O(log(m + n))
# Space Complexity: O(1)
'''
Another hard problem that I just copied off of Neetcode's solution. Could NOT get this one at all, I have
no idea why, man fuck this shit. Anyways, time complexity is O(log(m + n)) because if you imagine merging both
arrays and make it into a bigger array, you're technically doing a binary search on the bigger sorted array. The 
bigger sorted array is also size of (n + m) so the time complexity will be O(log(m + n)). Space complexity is
O(1) because we didn't use any external data structures. Ignore my bruteforce lol wtff even is that shit. 
'''
def findMedianSortedArrays(nums1, nums2):
    firstHalf, secondHalf = nums1, nums2
    total = len(nums1) + len(nums2)
    half = total // 2

    if len(secondHalf) < len(firstHalf):
        firstHalf, secondHalf = secondHalf, firstHalf

    l, r = 0, len(firstHalf) - 1
    while True:
        i = (l + r) // 2
        j = half - i - 2

        firstHalfLeft = firstHalf[i] if i >= 0 else float("-infinity")
        firstHalfRight = firstHalf[i + 1] if (i + 1) < len(firstHalf) else float("infinity")
        secondHalfLeft = secondHalf[j] if j >= 0 else float("-infinity")
        secondHalfRight = secondHalf[j + 1] if (j + 1) < len(secondHalf) else float("infinity")

        if firstHalfLeft <= secondHalfRight and secondHalfLeft <= firstHalfRight:
            if total % 2:
                return min(firstHalfRight, secondHalfRight)
            return (max(firstHalfLeft, secondHalfLeft) + min(firstHalfRight, secondHalfRight)) / 2
        elif firstHalfLeft > secondHalfRight:
            r = i - 1
        else:
            l = i + 1
    
    '''
    buildArr = []

    leftArr, rightArr = 0, 0

    while(leftArr < len(nums1) or rightArr < len(nums2)):

        if(leftArr < len(nums1) and rightArr < len(nums2) and nums1[leftArr] < nums2[rightArr]):
            buildArr.append(nums1[leftArr])
            if(leftArr < len(nums1)):
                leftArr += 1
        elif(leftArr < len(nums1) and rightArr < len(nums2) and nums1[leftArr] > nums2[rightArr]):
            buildArr.append(nums2[rightArr])
            if(rightArr < len(nums2)):
                rightArr += 1
        else:
            if(leftArr < len(nums1)):
                buildArr.append(nums1[leftArr])
                leftArr += 1
            if(rightArr < len(nums1)): 
                buildArr.append(nums2[rightArr])
                rightArr += 1

    if(len(buildArr)%2 == 0):
        num1 = (len(buildArr)-1)//2
        num2 = buildArr[buildArr.index(num1) + 1]
        return (num1 + num2) / 2 
    else:
        return buildArr[len(buildArr)/2]
    '''
print(findMedianSortedArrays([1,3], [2,4]))















