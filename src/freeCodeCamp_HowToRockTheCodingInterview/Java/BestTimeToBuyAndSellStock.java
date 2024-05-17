package freeCodeCamp_HowToRockTheCodingInterview.Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BestTimeToBuyAndSellStock {
//    You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,1,2,0,1}));
    }

    public static int maxProfit(int[] prices) {

        if (prices.length == 2 && prices[0] > prices[1]) {
            return 0;
        } else if (prices.length == 2 && prices[0] < prices[1]) {
            return prices[1] - prices[0];
        }

        int currBuyIndex = 0;
        int currSellIndex = prices.length - 1;
        for (int i = 0; i < prices.length / 2; i++) {
            if (prices[currBuyIndex + 1] <= prices[currBuyIndex]) {
                currBuyIndex++;
            }
            if (prices[currSellIndex - 1] >= prices[currSellIndex]) {
                currSellIndex--;
            }
        }

        return prices[currSellIndex] - prices[currBuyIndex];
    }
}
