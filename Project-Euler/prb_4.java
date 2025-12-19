public class prb_4 {
    // n is the number of two-digit numbers used to make the product
    public static long largest_palindrome_product(int n) {
        /*
        Create upper and lower bounds based on 10 to the power of the digits required
        Eg. 3 means 1000, 2 means 100 
        */
        long upper_bound = (long) Math.pow(10, n) - 1;
        long lower_bound = (long) Math.pow(10, n - 1);
        long max_product = 0;

        // iterate from largest numbers to lowest, since we want to get largest product, no need to check from bottom
        for (long i = upper_bound; i >= lower_bound; i--) {
            for (long j = i; j >= lower_bound; j--) {
                long product = i * j;
                // this case only runs if we find another, and if its lower we know we wont find another since we are iterating down so break
                if (product <= max_product) {
                    break;
                }
                // check if its a palindrome
                if (check_palindrome(product)) {
                    max_product = product;
                }
            }
        }

        return max_product;
    }

    public static boolean check_palindrome(long product) {
        String digits = String.valueOf(product); // convert to string
        // check if its equal to itself reversed
        return digits.equals(new StringBuilder(digits).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(largest_palindrome_product(3));

        // solution: 906609
    }
}
