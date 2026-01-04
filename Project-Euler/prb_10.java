public class prb_10 {
    public static long sum_of_primes_in_range(int range) {
        long sum = 2;

        for (int i = 3; i < range; i += 2) {
            if (is_prime(i)) {
                sum += i;
            }
        }

        return sum;
    }

    public static boolean is_prime(int n) {
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(sum_of_primes_in_range(2000000));

        // solution: 142913828922
    }
}
