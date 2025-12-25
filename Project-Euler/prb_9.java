public class prb_9 {
    public static int product_of_pythag_triplet(int triple_sum) {
        // optimization: 'a' must be less than sum/3 because a < b < c
        for (int a = 1; a < triple_sum / 3; a++) {

            // optimization: 'b' must be less than sum/2
            for (int b = a + 1; b < triple_sum / 2; b++) {

                // calculate c directly
                int c = triple_sum - (a + b);

                // check if it's a triplet
                if ( (a * a) + (b * b) == (c * c) ) {
                    System.out.println("Found: %d, %d, %d".formatted(a, b, c));
                    return a * b * c;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(product_of_pythag_triplet(1000));

        // solution: 31875000
    }
}
