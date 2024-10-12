import java.util.Arrays;

public class valid_anagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { // handle edge case
            return false;
        }

        char[] strS = s.toCharArray(), strT = t.toCharArray(); // convert string to arrays

        Arrays.sort(strS); // sort the arrays
        Arrays.sort(strT);
        
        return Arrays.equals(strS, strT); // return based on whether they are the same
    }
    public static void main(String[] args) {
        String s = "racecar", t = "carrace";
        String s2 = "jar", t2 = "jam";

        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram(s2, t2));

        // time complexity is O(nlogn) due to using array sort method (merge sort) so space complexity is O(n) as its merge sort
    }
}
