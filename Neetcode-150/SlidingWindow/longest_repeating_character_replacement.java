import java.util.HashMap;

public class longest_repeating_character_replacement {
    public static int characterReplacement(String s, int k) {
        /*
        HashMap<Character, Integer> map = new HashMap<>();
        int freq = 1, max_replacement_freq = 0;
        char max_character = s.charAt(0);
        String max_replacement_str = "";

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                if (map.get(c) >= freq) {
                    freq = map.get(c);
                    max_character = c;
                }
            }
            else {
                map.put(c, 1);
            }
        }

        System.out.println(max_character);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != max_character && k > 0) {
                max_replacement_str += max_character;
                k--;
            }
            else {
                max_replacement_str += s.charAt(i);
            }
        }
        System.out.println(max_replacement_str);
        
        for (int i = 0; i < max_replacement_str.length(); i++) {
            int counter = 1;
            for (int j = i + 1; j < max_replacement_str.length(); j++) {
                if (max_replacement_str.charAt(j) != max_replacement_str.charAt(i)) {
                    break;
                }
                else {
                    counter++;
                }
            }
            max_replacement_freq = Math.max(max_replacement_freq, counter);
        }

        return max_replacement_freq;
        */

        HashMap<Character, Integer> count = new HashMap<>(); // count of each character
        int res = 0;

        int l = 0, maxf = 0; // l is the left pointer, maxf is the maximum frequency of a character in the window

        for (int r = 0; r < s.length(); r++) { // r is the right pointer and we will keep moving it to the right
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1); // increment the count of the character at the right pointer or add it to the map if it doesn't exist
            maxf = Math.max(maxf, count.get(s.charAt(r))); // update the maximum frequency of a character in the window

            while ((r - l + 1) - maxf > k) { // if the window size - maxf > k, we need to shrink the window
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1); // decrement the count of the character at the left pointer
                l++; // move the left pointer to the right
            }
            res = Math.max(res, r - l + 1); // update the result by taking the maximum of the current result and the window size this works because we are only increasing the window size
        }

        return res;
    }
    public static void main(String[] args) {
        String s1 = "XYYX", s2 = "AAABABB", s3 = "AABABBA", s4 = "ABCDE";
        int k1 = 2, k2 = 1;
        
        System.out.println(characterReplacement(s1, k1));
        System.out.println(characterReplacement(s2, k2));
        System.out.println(characterReplacement(s3, k2));
        System.out.println(characterReplacement(s4, k2));

        // time complexity is O(n) and space complexity is O(m)
    }
}
