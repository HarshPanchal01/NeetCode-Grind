import java.math.BigInteger;

public class prb_15 {
    public static BigInteger lattice_paths(int length, int width) {
        /*
        If you look at the grid, to get from top left to bottom right, you must move right width times and down length times
        in any order. No matter what path you take, for example a 20 x 20 grid, you must take exactly 20 right moves and 20 down moves.
        This is like pascals triangle turned on its side.
        You can calculate this using the binomial coefficient formula:
            Paths = ((n + m)!) / (n! x m!)
            eg. n = 20, m = 20
            Paths = (40!) / (20! x 20!)
        */

        BigInteger l_factorial = factorial(length);
        BigInteger w_factorial = factorial(width);
        BigInteger lw_factorial = factorial(length + width);

        BigInteger total_paths = lw_factorial.divide(l_factorial.multiply(w_factorial));
        
        return total_paths;
    }

    public static BigInteger factorial(int num) {
        BigInteger sum = new BigInteger(Integer.toString(num));

        for (int i = num - 1; i >= 1; i--) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(lattice_paths(20, 20));

        // solution: 137846528820
    }
}
