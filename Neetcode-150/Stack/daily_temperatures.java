import java.util.Arrays;
import java.util.Stack;

public class daily_temperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        /*
        Brute force approach O(n^2)

        int counter = 0, greater = 0;
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length - 1; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                counter++;
                if (temperatures[j] > temperatures[i]) {
                    greater = 1;
                    break;
                }
            }
            if (greater == 1) {
                result[i] = counter;
                greater = 0;
            }
            counter = 0;
        }

        return result;
        */

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) { // loop through temperatures array
            // idea is to loop through the stack and keep popping until the current temperature is greater than the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) { // basically while the stack isnt empty and the current temperature is greater than the top of the stack
                int n = stack.pop(); // get the index of the top
                result[n] = i - n; // set the result as the difference between the current index and the index of top of stack
            }
            stack.push(i); // just push the index of current temperature if stack is empty
        }
    
        return result;
    }
    public static void main(String[] args) {
        int[] temperatures = {30,38,30,36,35,40,28}, temperatures2 = {22,21,20};

        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(dailyTemperatures(temperatures2)));

        // time and space complexity will be O(n) as we loop through the array once and use stack up to size of array
    }
}