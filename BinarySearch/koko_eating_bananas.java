import java.util.Arrays;

public class koko_eating_bananas {
    public static int minEatingSpeed(int[] piles, int h) {
        /*
        Brute Force O(m * n) approach

        int curr_speed = 1;
        
        while (true) {
            long time_taken = 0;
            for (int pile : piles) {
                time_taken += (int) Math.ceil((double) pile / curr_speed);
            }
            if (time_taken <= h) {
                return curr_speed;
            }
            curr_speed++;
        }
        */

        int left = 1, right = Arrays.stream(piles).max().getAsInt(), mid, k = right; // set the pointers for left and right and set k to initially be the max of piles as thats worst case
        // left, right, mid are pointers for the range of k because at worst k will be max pile and at best k is 1
        while (left <= right) { // apply binary search approach so while left and right dont cross each other
            mid = (left + right) / 2; // calculate the mid point which will be the speed
            int time_taken = 0; // set the time counter to 0

            for (int pile : piles) {
                time_taken += (int) Math.ceil((double) pile / mid); // loop through the piles and add the time taken at each pile based on speed (mid)
            }

            if (time_taken <= h) { // if we find that time taken for this speed was within h then we update k if this speed was smaller then we move right pointer to find the next smallest if exists
                k = Math.min(k, mid);
                right = mid - 1;
            }
            else { // otherwise the time taken was too long, so we have to shift our left pointer because we need higher speed
                left = mid + 1;
            }
        }

        return k;
    }
    public static void main(String[] args) {
        int[] piles = {1,4,3,2}, piles2 = {25,10,23,4};
        int h = 9, h2 = 4;

        System.out.println(minEatingSpeed(piles, h));
        System.out.println(minEatingSpeed(piles2, h2));

        // time complexity of this is O(Log(m) * n) where m is the max value of a pile in piles and n is the length of piles
        // space complexity of this is just O(1)
    }
}