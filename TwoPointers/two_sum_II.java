import java.util.Arrays;

public class two_sum_II {
    public static int[] twoSum(int[] numbers, int target) {
        /*
        Brute Force O(n^2) approach
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (target - numbers[j] == numbers[i]) {
                    return new int[] {i+=1, j+=1};
                }
            }
        }       
        return new int[] {}; 
        */
        int left = 0, right = numbers.length - 1, sum = 0; // pointers for start and end of the array, and variable to hold their sum

        while (left < right) { // as long as the left pointer has not gone past or is equal to the right pointer
            sum = numbers[left] + numbers[right]; // calculate their sum

            if (sum == target) { // if the sum is the target then we can just return the indexes of the two numbers
                return new int[] {left+=1, right+=1};
            }
            else if (sum > target) { // if the sum is greater than the target it means we need to decrement right pointer
                right--;
            }
            else { // last case where the sum is less than the target then we need to increment the left pointer
                left++;
            }   
        }
        // this solution only works because the array given will always be sorted
        return new int[] {};
    }
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        int target = 3;

        System.out.println(Arrays.toString(twoSum(numbers, target)));

        // time complexity of this will be O(n) as at worst case we loop through the entire array, and the space complexity is O(1)
    }
}