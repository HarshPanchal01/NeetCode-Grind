public class prb_0 {
    public static long sum_of_odd_squares_in_range(long start, long end) {
        long sum = 0;
        
        for (long i = start; i < end; i++) {
            if (i % 2 != 0) {
                sum += (i * i);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum_of_odd_squares_in_range(1, 485000));
    }
}
