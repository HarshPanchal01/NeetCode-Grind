public class prb_17 {
    private static final String[] ONES = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] TENS = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static int number_letter_counts(int start, int end) {
        String total_letters = "", curr_letters;
        int curr_num;

        for (int i = start; i <= end && i < 1000; i++) {
            curr_letters = "";
            curr_num = i;

            // handle the hundreds
            if (curr_num >= 100) {
                curr_letters += ONES[curr_num / 100]; // get the number of hundres eg. 300 / 100 = 3 so three hundred
                curr_letters += "hundred";

                if (curr_num % 100 != 0) { // add the word 'and' if not a clean hundred, so any hundred which is not whole like 301, 999
                    curr_letters += "and";
                }
            }

            curr_num = curr_num % 100; // get the last two digits so basically the tens and ones

            if (curr_num > 0) {
                if (curr_num < 20) { // map to the array itself
                    curr_letters += ONES[curr_num];
                }
                else { // first map to the tens then the ones
                    curr_letters += TENS[curr_num / 10];
                    curr_letters += ONES[curr_num % 10];
                }
            }

            //System.out.println(curr_letters);
            total_letters += curr_letters;
        }

        if (end == 1000) { // hardcoded but add the thousand
            total_letters += "onethousand";
        }

        return total_letters.length();
    }
    
    public static void main(String[] args) {
        System.out.println(number_letter_counts(1, 1000));

        // solution: 21124
    }
}
