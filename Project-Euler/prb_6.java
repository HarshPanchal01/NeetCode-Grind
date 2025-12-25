public class prb_6 {
    public static int difference_between_sum_of_squares_in_range(int start, int end) {
        int square_of_sum = 0, sum_of_squares = 0, difference = 0;

        for (int i = start; i <= end; i++) {
            square_of_sum += i;
            sum_of_squares += Math.pow(i, 2);
        }

        difference += Math.pow(square_of_sum, 2) - sum_of_squares;
        
        return difference;
    }

    public static void main(String[] args) {
        System.out.println(difference_between_sum_of_squares_in_range(1, 100));

        // solution: 25164150
    }
}
