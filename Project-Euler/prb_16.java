import java.math.BigInteger;

public class prb_16 {
    public static int power_digit_sum(int digit, int power) {
        BigInteger base = BigInteger.valueOf(digit);
        BigInteger sum = base.pow(power);

        String sum_str = sum.toString();
        int digit_sum = 0;

        for (char d : sum_str.toCharArray()) {
            digit_sum += d - '0';
        }

        return digit_sum;
    }

    public static void main(String[] args) {
        System.out.println(power_digit_sum(2, 1000));

        // solution: 1366
    }
}
