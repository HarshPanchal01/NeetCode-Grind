import java.util.Stack;

public class minimum_stack {
    static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        
        public MinStack() {
            // we need two stacks one normal, and one for minimum to get the minimum in O(1) time
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val); // push normally to this stack
            val = Math.min(val, minStack.isEmpty() ? val : minStack.peek()); // get the minimum 
            minStack.push(val); // push that min val to the minStack
        }

        public void pop() { // just pop from both
            stack.pop();
            minStack.pop();
        }

        public int top() { // use peek function as it returns the top of the stack without removing it
            return stack.peek();
        }

        public int getMin() { // use peek function to return the top as in the minStack top value will always be the minimum
            return minStack.peek();
        }

        public void printStack() {
            System.out.println(stack);
            System.out.println(minStack);
        }
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(1);
        minStack.printStack();
        minStack.push(2);
        minStack.printStack();
        minStack.push(0);
        minStack.printStack();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.printStack();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        // time complexity will be O(1) for all functions but space complexity can be O(n) depending on size of stack
    } 
}
