//package Array.Best Time to Buy and Sell Sorted Array;
/*

Best Time to Buy and Sell Stock II


You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

Ex:-1

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.

Ex:-2

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.

Ex:-3

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.


Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104

*/

class Solution {
   public static void main(String[] args) {
      int[] arr = { 7, 6, 4, 3, 1 };
      System.out.println(maxProfit(arr));
   }

   public static int maxProfit(int[] prices) {
      int profit = 0;
      for (int i = 0; i < prices.length - 1; i++)
         if (prices[i] < prices[i + 1])
            profit += prices[i + 1] - prices[i];
      return profit;
   }
}

/*
class Solution {
   public int maxProfit(int[] prices) {
      int result = 0;
      for (int i = 1; i < prices.length; i++) {
         if (prices[i] > prices[i - 1]) {
            result += prices[i] - prices[i - 1];
         }
      }
      return result;
   }
}


class Solution {
   public int maxProfit(int[] prices) {
      int n = prices.length; // arr define
      int sum = 0;// new variable form
      for (int i = 0; i < n - 1; i++) { // traverse the loop from o index till n-1 i e last index.
         while (i < n - 1 && prices[i] > prices[i + 1]) {// cond:1 curr price is greater than next prices i.e 7>1.
            i++;// update ith index
         }
         int buy = prices[i];// cond :2 current price<next prices i e 1<5 at this cond we have to buy the
                             // stock and traverde till end .
         while (i < n - 1 && prices[i] < prices[i + 1]) {
            i++;// update i th index
         } // out of the cond:2
         int sell = prices[i];// acc to cond:1 at this prices we have to sell the stock.
         sum += sell - buy;// maximize the profit by taking sum of max profit
      }

      return sum;// got the output as this is not void statement.

   }
}
*/