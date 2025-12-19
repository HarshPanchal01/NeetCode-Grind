import java.util.HashSet;

public class longest_consecutive_sequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) { // edge-case where the array is empty or has only one element
            return nums.length;
        }

        HashSet<Integer> set = new HashSet<>(); // create hashset as adding to it is constant O(1) and it doesn't allow duplicates

        for (int n : nums) { // add all unique elements to hashset
            set.add(n);
        }

        int max = 1; // counter to hold the max sequence
        for (int n : set) { // loop through the set
            if (!set.contains(n - 1)) { // if the set does not have an element one less than the current then it means current element is start of a sequence
                int counter = 1; // set our counter to 1
                while (set.contains(n + counter)) { // check if the set contains element n+1, n+2, n+3 ... and increment counter each time
                    counter++;
                }
                if (max < counter) { // at the end update max sequence
                    max = counter;
                }
            }
        }

        return max; // return the value
    }
    public static void main(String[] args) {
        int[] nums = {2,20,4,10,3,4,5}, nums2 = {0,3,2,5,4,6,1,1}, nums3 = {9,1,4,7,3,-1,0,5,8,-1,6};

        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive(nums2));
        System.out.println(longestConsecutive(nums3));

        // time and space complexity here is O(n) as we just loop through the array and hashset respectively
    }
}
