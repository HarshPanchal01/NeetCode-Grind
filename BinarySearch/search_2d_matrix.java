public class search_2d_matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        /*
        Brute Force O(n * m) approach

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
        */
        int columns = matrix[0].length - 1, rows = matrix.length - 1; // get the dimensions of the matrix
        int left = 0, right = (rows * columns) - 1, mid; // pointers for the binary search approach

        while (left <= right) { // apply the same binary search approach for left and right not crossing each other
            mid = (left + right) / 2; // calculate the mid

            if (matrix[mid / columns][mid % columns] == target) { // converting the mid to matrix coordinates, mid / columns gives the index for the row and mid % columns gives the column index
                return true;
            }
            else if (matrix[mid / columns][mid % columns] < target) { // if the mid coordinates element is less than the target then move left to right of mid
                left = mid + 1;
            }
            else { // otherwise move right to left of mid as the target is less than mid coordinates element
                right = mid - 1;
            }
        }

        return false; // return false if target was not found
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,4,8},{10,11,12,13},{14,20,30,40}};
        int target = 10, target2 = 15;

        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrix(matrix, target2));

        // time complexity of this is O(log(n * m)) and the space complexity is O(1)
    }
}