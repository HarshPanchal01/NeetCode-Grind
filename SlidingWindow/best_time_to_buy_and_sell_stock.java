public class best_time_to_buy_and_sell_stock {
    public static int maxProfit(int[] prices) {
        /*
        Brute force approach O(n^2)

        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }

        return max;
        */

        int left = 0, right = 1, max = 0; // counters for each, have left be used for buying and right for selling

        while (right < prices.length) { // only right will get to the end of the array
            if (prices[left] < prices[right]) { // if we can profit, as the buy will be less than the sell
                max = Math.max(max, prices[right] - prices[left]); // update the max profit counter
            }
            else { // otherwise it means that our sell value is smaller than our buy so lets move our buy there
                left = right;
            }
            right++; // increment right everytime regardless because it will be the one to reach the end of the array
        }

        return max; // return the max profit
    }
    public static void main(String[] args) {
        int[] prices1 = {10, 1, 5, 6, 7, 1}, prices2 = {10, 8, 7, 5, 2};

        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));

        // time complexity is O(n) and space complexity is O(1)
    }        
}
