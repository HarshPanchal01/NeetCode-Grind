import java.util.HashSet;

public class valid_sudoku {
    @SuppressWarnings("unchecked") // just to surpress a warning given on run time
    public static boolean isValidSudoku(char[][] board) {
        // we want to create an array of hashsets one for rows, one for columns, and one for the boxes in sudoku and we know each will hold 9 elements
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) { // so we initialize the hashsets
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) { // double for loop to iterate over each cell in the board
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') { // if the cell is empty just continue to next element
                    continue;
                }

                if (rows[i].contains(board[i][j])) { // if the current row already contains this element then its false
                    return false;
                }
                rows[i].add(board[i][j]); // add to the current row otherwise

                if (columns[j].contains(board[i][j])) { // if the current column already contains this element then its false
                    return false;
                }
                columns[j].add(board[i][j]); // add to the current column otherwise

                int box_index = (i / 3) * 3 + (j / 3); // we need to first calculate the indices of i, j to the box which is 3x3, since its integer it will automatically floor fractions
                if (boxes[box_index].contains(board[i][j])) { // if element already is in the box then its false
                    return false;
                }
                boxes[box_index].add(board[i][j]); // add to the box otherwise
            }
        }
        // if no duplicates found then its true
        return true;
    }
    public static void main(String[] args) {
        char[][] board = 
        {{'1','2','.','.','3','.','.','.','.'},
        {'4','.','.','5','.','.','.','.','.'},
        {'.','9','8','.','.','.','.','.','3'},
        {'5','.','.','.','6','.','.','.','4'},
        {'.','.','.','8','.','3','.','.','5'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','.','.','.','.','.','2','.','.'},
        {'.','.','.','4','1','9','.','.','8'},
        {'.','.','.','.','8','.','.','7','9'}}, 
        board2 = 
        {{'1','2','.','.','3','.','.','.','.'},
        {'4','.','.','5','.','.','.','.','.'},
        {'.','9','1','.','.','.','.','.','3'},
        {'5','.','.','.','6','.','.','.','4'},
        {'.','.','.','8','.','3','.','.','5'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','.','.','.','.','.','2','.','.'},
        {'.','.','.','4','1','9','.','.','8'},
        {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku(board2));

        // time and space complexity is O(1) because every sudoku board will be 9x9 meaning we always process 81 cells
    }
}