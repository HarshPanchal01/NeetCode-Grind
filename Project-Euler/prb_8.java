public class prb_8 {
    public static long largest_product_in_series(String series, int nums_adj) {
        long max_product = 0, curr_product = 0;

        // iterate through until end - length of our product builder so we dont go out of bounds
        for (int i = 0; i < series.length() - nums_adj; i++) {
            // if its zero then no point of doing the calculation so just skip
            if (series.charAt(i) - '0' == 0) {
                continue;
            }

            curr_product += series.charAt(i) - '0';

            // go from i + 1 until we have built the length of our num to get the product
            for (int j = i + 1; j < i + nums_adj; j++) {
                curr_product *= series.charAt(j) - '0';
            }

            // keep the greater value
            max_product = Math.max(max_product, curr_product);

            curr_product = 0;
        }

        return max_product;
    }

    public static void main(String[] args) {
        String series = 
            "73167176531330624919225119674426574742355349194934" +
            "96983520312774506326239578318016984801869478851843" +
            "85861560789112949495459501737958331952853208805511" +
            "12540698747158523863050715693290963295227443043557" +
            "66896648950445244523161731856403098711121722383113" +
            "62229893423380308135336276614282806444486645238749" +
            "30358907296290491560440772390713810515859307960866" +
            "70172427121883998797908792274921901699720888093776" +
            "65727333001053367881220235421809751254540594752243" +
            "52584907711670556013604839586446706324415722155397" +
            "53697817977846174064955149290862569321978468622482" +
            "83972241375657056057490261407972968652414535100474" +
            "82166370484403199890008895243450658541227588666881" +
            "16427171479924442928230863465674813919123162824586" +
            "17866458359124566529476545682848912883142607690042" +
            "24219022671055626321111109370544217506941658960408" +
            "07198403850962455444362981230987879927244284909188" +
            "84580156166097919133875499200524063689912560717606" +
            "05886116467109405077541002256983155200055935729725" +
            "71636269561882670428252483600823257530420752963450";

        int nums_adj = 13;
        
        System.out.println(largest_product_in_series(series, nums_adj));
    }
}
