import java.util.Stack;

public class largest_rectangle_in_histogram {
    public static int largestRectangleArea(int[] heights) {
        /*
        Brute Force O(n^3) approach

        int largest_area = 0, height = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            height = heights[i];
            stack.push(height);
            int j = i + 1;
            while (j < heights.length && heights[i] <= heights[j]) {
                stack.push(heights[j]);
                j++;
            }
            int k = i - 1;
            while (k >= 0 && heights[i] <= heights[k]) {
                stack.push(heights[k]);
                k--;
            }

            largest_area = Math.max(largest_area, stack.size() * height);
            stack.clear();
        }

        return largest_area;

        */

        

    }
    public static void main(String[] args) {
        int[] heights = {7,1,7,2,2,4}, heights2 = {2,3};

        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleArea(heights2));
    }
}
