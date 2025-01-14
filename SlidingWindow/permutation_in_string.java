import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class permutation_in_string {
    /*
    Brute force approach O(n! * m) as we check all permutations

    // Helper method to generate all permutations of a string
    private static void generatePermutations(String prefix, String remaining, Set<String> result) {
        if (remaining.length() == 0) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            generatePermutations(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), result);
        }
    }

    public static boolean checkInclusion(String s1, String s2) {
        // Generate all permutations of s1
        Set<String> permutations = new HashSet<>();
        generatePermutations("", s1, permutations);

        // Check if any permutation exists in s2
        for (String perm : permutations) {
            if (s2.contains(perm)) {
                return true;
            }
        }
        return false;
    }
    */

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // Create frequency maps for s1 and the first window of s2
        Map<Character, Integer> s1Count = new HashMap<>();
        Map<Character, Integer> windowCount = new HashMap<>();

        // Initialize s1Count and the first windowCount
        for (char c : s1.toCharArray()) {
            s1Count.put(c, s1Count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
        }

        // Compare initial window
        if (s1Count.equals(windowCount)) {
            return true;
        }

        // Slide the window across s2
        for (int i = s1.length(); i < s2.length(); i++) {
            char newChar = s2.charAt(i); // New character entering the window
            char oldChar = s2.charAt(i - s1.length()); // Old character leaving the window

            // Add the new character to the window
            windowCount.put(newChar, windowCount.getOrDefault(newChar, 0) + 1);

            // Remove the old character from the window
            if (windowCount.get(oldChar) == 1) {
                windowCount.remove(oldChar);
            } else {
                windowCount.put(oldChar, windowCount.get(oldChar) - 1);
            }

            // Compare the updated window with s1Count
            if (s1Count.equals(windowCount)) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        String s1 = "abc", s2 = "lecabee", s3 = "lecaabee";

        System.out.println(checkInclusion(s1, s2));
        System.out.println(checkInclusion(s1, s3));

        // time complexity is O(m + n) and space complexity is O(1)
    }
}