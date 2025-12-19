import java.util.Stack;

public class evaluate_reverse_polish_notation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); // use stack to store the numbers and result of expression

        for (String str : tokens) {
            // when the current string is a number and not an operator just add to stack
            if (!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
                stack.add(Integer.parseInt(str));
            }
            else { // when we get to an operator then we can calculate the expression
                // get the top 2 numbers or last 2 numbers we added as we will perform the operation on them operand1 should be 2nd last and order matters for subtraction and division
                int operand2 = stack.pop();
                int operand1 = stack.pop(); // also pop those 2 top numbers we got, we will add their result back in place of them

                switch (str) { // using switch statement for each of the 4 operators it can be
                    // just perform the operation on those 2 operands and add back to the stack
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop(); // return top of stack as the stack at this point will only contain one element and it will be the result of the expressions
    }
    public static void main(String[] args) {
        String[] tokens = {"1", "2", "+", "3", "*", "4", "-"};
        
        System.out.println(evalRPN(tokens));

        // time and space complexity will be O(n) as we loop through array and create stack
    }
}