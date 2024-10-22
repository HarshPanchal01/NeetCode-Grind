import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class generate_parentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>(); // store all possibilities in this list
        Stack<Character> parentheses = new Stack<>(); // we want to use a stack to keep track of all the parenthesis we have

        backtrack(n, 0, 0, parentheses, result); // use back-tracking to solve the problem

        return result;
    }

    private static void backtrack(int n, int open_parenthesis, int close_parenthesis, Stack<Character> parentheses, List<String> result) { // back-track function
        if (open_parenthesis == close_parenthesis && open_parenthesis == n) { // if the amount of '(' is the same as ')' and its equal to n means this is the start
            StringBuilder str = new StringBuilder(); // use string-builder to build the string

            for (char c : parentheses) { // add from stack
                str.append(c);
            }

            result.add(str.toString()); // add string to result list
            return;
        }

        if (open_parenthesis < n) { // if the number of '(' is less than n it means we can push that to the stack
            parentheses.push('(');
            backtrack(n, open_parenthesis + 1, close_parenthesis, parentheses, result); // call the function and increment the '(' counter
            parentheses.pop(); // remove the last element which would be what we just added
        }

        if (close_parenthesis < open_parenthesis) { // if the number of ')' is less than '(' it means we can add that to the stack
            parentheses.push(')');
            backtrack(n, open_parenthesis, close_parenthesis + 1, parentheses, result); // call the function and increment the ')' counter
            parentheses.pop(); // again remove last element
        }
    }
    public static void main(String[] args) {
        int n = 1, n2 = 3;

        System.out.println(generateParenthesis(n));
        System.out.println(generateParenthesis(n2));

        // time and space complexity of this would be too great for this function over O(2^n)
    }
}