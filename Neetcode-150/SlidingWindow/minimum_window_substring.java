import java.util.ArrayList;

public class minimum_window_substring {
    public static String minWindow(String s, String t) {
        
        if (t.length() > s.length()) {
            return "";
        }

        String output = "";
        ArrayList<Character> set_t = new ArrayList<>();

        for (char c : t.toCharArray()) {
            set_t.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            String temp_output = "";
            ArrayList<Character> temp_set_t = new ArrayList<>();
            temp_set_t.addAll(set_t);

            for (int j = i; j < s.length(); j++) {
                if (temp_set_t.isEmpty()) {
                    break;
                }
                else if (temp_output != "") {
                    temp_output += s.charAt(j);
                    if (temp_set_t.contains(s.charAt(j))) {
                        temp_set_t.remove(Character.valueOf(s.charAt(j)));
                    }
                }
                else if (temp_set_t.contains(s.charAt(j)) && temp_output == "") {
                    temp_output += s.charAt(j);
                    temp_set_t.remove(Character.valueOf(s.charAt(j)));
                }
            }

            if (temp_set_t.isEmpty()) {
                if (output != "" && output.length() > temp_output.length() && temp_output != "") {
                    output = temp_output;
                }
                else if (output == "" && temp_output != "") {
                    output = temp_output;
                }
            }
        }

        return output;
    }
    public static void main(String[] args) {
        String s = "OUZODYXAZV", t = "XYZ";

        System.out.println(minWindow(s, t));

        // Time complexity: O((n^2) * m) Space complexity: O(m)
    }
}
