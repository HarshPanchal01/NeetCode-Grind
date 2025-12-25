public class prb_7 {
    public static int n_prime_number(int n) {
        int prime_number = 0, counter = 0;

        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (is_prime(i)) {
                counter++;

                if (counter == n) {
                    prime_number = i;
                    break;
                }
            }
        }

        return prime_number;
    }

    public static boolean is_prime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(n_prime_number(10001));

        // solution: 104743
    }
}
