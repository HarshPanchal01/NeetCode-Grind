# Time Complexity: O(1)
# Space Complexity: O(1) 
'''
The time and space complexity will be O(1) since it'll always be a constant number of iterations, and the 
hashmaps will always have a constant size regardless of the input(as long as the input is bound by the constraints)
'''

def isValidSudoku(board):

    # O(1) since it'll always iterate 9 times regardless of the input
    # Iterate through the rows
    for row in board:
        rowMap = {}
        for cell in row:
            if(cell != '.' and cell in rowMap):
                return False
            else:
                rowMap[cell] = 0
    print("row")

    # O(1) since it'll always iterate 9 times regardless of the input
    # Iterate through the columns
    for col in range(len(board)):
        colMap = {}
        for row in range(len(board)):
            if(board[row][col] != '.' and board[row][col] in colMap):
                return False
            else:
                colMap[board[row][col]] = 0

    print("col")


    # O(1) since it'll always iterate 9 times regardless of the input
    # Iterate through the sub-boxes 
    rowLower, rowUpper = 0, 2
    colLower, colUpper = 0, 2
    for i in range(9):
        subBoxMap = {}
        for row in range(rowLower, rowUpper+1):
            for col in range(colLower, colUpper+1):
                print(subBoxMap, board[row][col])
                if(board[row][col] != '.' and board[row][col] in subBoxMap):
                    return False
                else:
                    subBoxMap[board[row][col]] = 0
        
        if(colUpper >= 8):
            rowLower += 3
            rowUpper += 3
            colLower, colUpper = 0, 2
        else:
            colLower += 3
            colUpper += 3
        


    
    print("sub-box")
    
    return True

print(isValidSudoku([["1","2",".",".","3",".",".",".","."],
 ["4",".",".","5",".",".",".",".","."],
 [".","9","8",".",".",".",".",".","3"],
 ["5",".",".",".","6",".",".",".","4"],
 [".",".",".","8",".","3",".",".","5"],
 ["7",".",".",".","2",".",".",".","6"],
 [".",".",".",".",".",".","2",".","."],
 [".",".",".","4","1","9",".",".","8"],
 [".",".",".",".","8",".",".","7","9"]]))

                












