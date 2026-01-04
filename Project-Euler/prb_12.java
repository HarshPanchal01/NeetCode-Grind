public class prb_12 {
    public static int highly_divisble_triangle_number(int divisors) {
        int curr_tri_num = 0, amount_divisors = 0;

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            // realize the pattern that triangle numbers are just previous term value plus term number
            curr_tri_num = curr_tri_num + i;
            amount_divisors = factors(curr_tri_num);
            
            //System.out.println("%d: %d".formatted(curr_tri_num, amount_divisors));

            if (amount_divisors > divisors) {
                return curr_tri_num;
            }
        }

        return -1;
    }

    public static int factors(int num) {
        int amount = 0;

        for (int i = 1; i <= Math.sqrt(num); i++) {
            // realize that if a number is divisible by a number the other number is also a factor so no need to go beyond the square root
            if (num % i == 0) {
                if (i * i == num) { // this case is only for perfect squares eg. 6 * 6 = 36
                    amount++;
                }
                else { // increment by two eg. 18 / 2 = 9 so 2 and 9 are factors of 18
                    amount += 2;
                }
            }
        }

        return amount;
    }

    public static void main(String[] args) {
        System.out.println(highly_divisble_triangle_number(500));
        
        // solution: 76576500
    }
}
