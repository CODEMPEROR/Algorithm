package alg.leetcode;

/**
 * Created by feng on 16/4/24.
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {


        int[] prices = new int[]{};

        System.out.print(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int index = -1;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min && index < i) {
                min = prices[i];
                index = i;
            }

            if (prices[i] > max) {
                max = prices[i];
            }
        }

        return max - min;
    }
}
