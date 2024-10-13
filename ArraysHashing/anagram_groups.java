import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class anagram_groups {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>(); // create the hashmap to store the string and the list of strings

        for (String s : strs) { // for each string in the array
            char[] charArray = s.toCharArray(); // first convert and sort array
            Arrays.sort(charArray);
            String sortedS = new String(charArray); // change back to string now
            res.putIfAbsent(sortedS, new ArrayList<>()); // if the string is not already in the hashmap put it and create the list for it
            res.get(sortedS).add(s); // the string is already in the hashmap so just add the string to the list
        }

        return new ArrayList<>(res.values()); // return the list of strings
    }
    public static void main(String[] args) {
        String[] strs = {"act","pots","tops","cat","stop","hat"}, strs2 = {"x"}, strs3 = {""};
        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams(strs2));
        System.out.println(groupAnagrams(strs3));

        // time complexity is O(m * nlogn) because of the sorting taking nlogn and the m comes from the number of strings
        // space complexity is O(m * n)
    }
}