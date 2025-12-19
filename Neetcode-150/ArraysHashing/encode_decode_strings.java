import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class encode_decode_strings {
    public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder(); // use stringbuilder to concatenate for efficiency

        for (String str : strs) { // loop through each string in the list
            encoded.append(str).append(']'); // append the string from the list and add ']' for decoding
        }

        return encoded.toString();
    } 

    public static List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        StringBuilder curr_str = new StringBuilder(); // keep track of current string we are building
        char[] arr = str.toCharArray(); // convert the string to decode into character array

        for (char c : arr) { // loop through each character
            if (c == ']') { // if we find our decoder character it means thats the end of the current string
                strs.add(curr_str.toString()); // add to the list
                curr_str.setLength(0); // reset the current string
            }
            else { // otherwise just append the character to current string
                curr_str.append(c);
            }
        }

        return strs;
    }
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>(Arrays.asList("neet", "code", "love", "you"));
        List<String> strs2 = new ArrayList<>(Arrays.asList("we", "say", ":", "yes"));

        System.out.println(decode(encode(strs)));
        System.out.println(decode(encode(strs2)));

        // time complexity and space complexity is O(n) as we are looping through entire array and list respectively
    }
}
