public class prb_1 {
    public static int multiples_of_two_numbers_in_a_range(int n, int m, int range) {
        int sum = 0;

        for (int i = 1; i < range; i++) {
            if (i % n == 0 && i % m == 0) {
                sum += i;
            }

            else if (i % n == 0) {
                sum += i;
            }

            else if (i % m == 0) {
                sum += i;
            }
            
            else {
                continue;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(multiples_of_two_numbers_in_a_range(3, 5, 1000));

        // solution: 233168
    }
}