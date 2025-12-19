import java.util.Stack;

public class valid_parentheses {
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) { // if the length is not a multiple of two it means one bracket is missing therefore not valid
            return false;
        }

        Stack<Character> stack = new Stack<>(); // we need to store in stack so that we can just pop the last element and compare to the first
        char[] arr = s.toCharArray(); // convert string to array to loop through each character

        for (char c : arr) {
            if (c == '(' || c == '[' || c == '{') { // if it is the beginning of a parentheses add to the stack
                stack.push(c);
                continue; // skip rest of for loop and start from next element
            }
            if (stack.isEmpty()) { // if stack is empty here it means that there was no beginning parentheses meaning it cant be valid
                return false;
            }
            char top = stack.pop(); // we want to get the top value which will always be the last value inserted
            if ((top == '(' && c != ')') || (top == '[' && c != ']') || (top == '{' && c != '}')) { // basically if the last inserted value and the element c is not valid bracket then return false
                return false;
            }
        }

        return stack.isEmpty(); // return true only is the stack was empty because if that would mean we popped all beginning parentheses if we found equal ending parentheses
    }
    public static void main(String[] args) {
        String s = "[]", s2 = "([{}])", s3 = "[(])";

        System.out.println(isValid(s));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));

        // time and space complexity here is O(n) as we loop through an array
    }
}