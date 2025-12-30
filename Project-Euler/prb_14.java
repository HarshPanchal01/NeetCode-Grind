import java.util.Arrays;

public class prb_14 {
    public static long longest_collatz_sequence_in_range(long start, long end) {
        long[] longest_chain = {0, 0}, curr_chain = {0, 0};

        for (long i = start; i <= end; i++) {
            curr_chain = collatz_chain_counter(i);
            //System.out.println(Arrays.toString(curr_chain));

            if (curr_chain[1] > longest_chain[1]) {
                longest_chain = curr_chain;
            }
        }
        
        System.out.println("Max is %d: %d".formatted(longest_chain[0], longest_chain[1]));
        return longest_chain[1];
    }

    public static long[] collatz_chain_counter(long n) {
        long counter = 1, n_copy = n;

        // the collatz formula, which is applied until the number becomes 1
        while (n_copy != 1) {
            if (n_copy % 2 == 0) {
                n_copy = n_copy / 2;
            }
            else {
                n_copy = (3 * n_copy) + 1;
            }

            counter++;
        }

        return new long[] {n, counter};
    }

    public static void main(String[] args) {
        System.out.println(longest_collatz_sequence_in_range(1, 999999));

        // solution: 837799
    }
}
