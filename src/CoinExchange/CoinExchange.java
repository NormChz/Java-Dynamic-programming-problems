package CoinExchange;

import java.util.Arrays;

public class CoinExchange {

    public int findMinCoins(int[]coins, int targetAmount) {

        // We create an array of amounts, and fill it with high values,
        // except for the first position, which we fill with the value 0.

        // Each position of the array represents an amount for which we need to find
        // the minimum number of coins that add up to it.
        // position 0 = amount 0, position 1 = amount 1, etc...

        // Position 0 represents the amount 0, and we can insert the value 0 at that
        // position, because no coins are needed to sum up to 0. It is the base case.
        // Therefore, value 0 at position 0 of the array, represents the number of needed coins
        // to sum up to 0.

        int[] amounts = new int[targetAmount + 1];
        Arrays.fill(amounts, targetAmount + 1);
        amounts[0] = 0; // BASE CASE

        // For all other "current amounts" that are greater than 0,
        // we parse the whole coin array: if a coin can be subtracted (without going below 0)
        // from the current amount, we modify the value in the amounts array at the position of
        // the current amount.

        // The new value that we insert will be the lowest value between the position's current value
        // and (1 + the value at the position of the array where we can find the nr of coins needed to sum
        // up to the remainder), that is 1 + amounts[current amount - value of coin]


        for (int currAmount = 1; currAmount <= targetAmount; currAmount++) {
            for (int coin : coins) {
                if ((currAmount - coin) >= 0) {

                    // amounts[currAmount - coin] contains the nr of coins needed to sum up
                    // to the remaining part of the value.
                    int remainingCoins = amounts[currAmount - coin];
                    int maxOrPrevMin = amounts[currAmount];

                    // amounts[currAmount] can be a MAX value, or a previously established
                    // minimum nr of coins. If 1 + remaining coins is lower than amounts[currAmount]
                    // it replaces that value.
                    amounts[currAmount] = Math.min(1 + remainingCoins, maxOrPrevMin);
                }
            }
        }

        System.out.println(Arrays.toString(amounts));
        return amounts[targetAmount];
    }

    public static void main(String[] args) {
        int[] coins = { 2, 5, 6};
        int amount = 11;
        CoinExchange ce = new CoinExchange();
        int minCoins = ce.findMinCoins(coins, amount);
        System.out.println(minCoins);

    }
}
