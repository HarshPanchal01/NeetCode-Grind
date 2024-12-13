import java.util.HashSet;

public class longest_substring_without_repeating_characters {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0, l = 0; // we want to have a left pointer that will go from start of the set/string
        
        for (int r = 0; r < s.length(); r++) { // we want to iterate through the string
            while (set.contains(s.charAt(r))) { // if the set already contains the character, we need to remove all the characters from the left pointer to the character that is already in the set
                set.remove(s.charAt(l)); // remove the character at the left pointer
                l++; // increment the left pointer
            }
            set.add(s.charAt(r)); // otherwise add the character to the set
            max = Math.max(max, r - l + 1); // update the max counter by comparing the current max and the difference between the right and left pointer
        }

        return max;
    }
    public static void main(String[] args) {
        String s1 = "zxyzxyz", s2 = "xxxx", s3 = "pwwkew";

        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));

        // time complexity is O(n) and space complexity is O(m) where m is the size of the set
    }
}