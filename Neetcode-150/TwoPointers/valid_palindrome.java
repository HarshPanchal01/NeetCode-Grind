public class valid_palindrome {
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", ""); // replace all non-alphanumeric characters and spaces
        s = s.toLowerCase(); // covert string to lowercase

        int left = 0, right = s.length() - 1; // have pointers for start and end of the string

        while (left <= right) { // loop until left pointer goes beyond right pointer
            if (s.charAt(left) != s.charAt(right)) { // if the characters dont equal each other at the left and right points it cant be palindrome
                return false;
            }
            // otherwise just increment the left pointer and decrement the right pointer
            left++;
            right--;
        }
        // if entire while loop finishes it means string was a palindrome
        return true;
    }
    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?", s2 = "tab a cat";

        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome(s2));

        // time complexity of this is O(n) and the space complexity is O(1)
    }    
}
