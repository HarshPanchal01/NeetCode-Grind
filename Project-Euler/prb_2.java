public class prb_2 {
    public static int fibonacci_sequence(int n) {
        if (n <= 1) {
            return n;
        }
        else {
            return fibonacci_sequence(n - 1) + fibonacci_sequence(n - 2);
        }
    }

    public static int sum_even_terms(int range) {
        int i = 0, sum = 0;

        while (true) {
            int curr = fibonacci_sequence(i);
            if (curr > range) { break; }
            if (curr % 2 == 0) { sum += curr; }

            i++;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum_even_terms(4000000));

        // solution: 4613732
    }
}
