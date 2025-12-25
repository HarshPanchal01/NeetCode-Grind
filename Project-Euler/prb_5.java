public class prb_5 {
    public static int smallest_multiple_in_range(int start, int end) {
        if (start <= 0 || end <= 0) {
            return -1;
        }

        int smallest_multiple = 0;

        // start from 2x end because at minimum thats needed to be evenly divisble by 2
        for (int i = end * 2; i <= Integer.MAX_VALUE; i++) {
            boolean evenly_divisble = true;

            for (int j = start; j <= end; j++) {
                if (i % j != 0) {
                    evenly_divisble = false;
                    break;
                }
            }

            if (evenly_divisble) {
                smallest_multiple = i;
                break;
            }

        }

        return smallest_multiple;
    }

    public static void main(String[] args) {
        System.out.println(smallest_multiple_in_range(1, 20));

        // solution: 232792560
    }
}