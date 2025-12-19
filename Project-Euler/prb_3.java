public class prb_3 {
    public static Long largest_prime_factor(long n) {
        long i = 2;
    
        // we only need to check up to sqrt(n) of the current n
        while (i * i <= n) {
            if (n % i != 0) {
                i++;
            } 
            else {
                // if i divides n, divide n by i completely.
                // this ensures we remove all factors of i.
                n /= i;
            }
        }
    
        // if n is still > 1, the remaining n is the largest prime factor.
        return n;
    }

    public static void main(String[] args) {
        System.out.println(largest_prime_factor(13195));
        System.out.println(largest_prime_factor(600851475143L));

        // solution: 6857
    }
}
