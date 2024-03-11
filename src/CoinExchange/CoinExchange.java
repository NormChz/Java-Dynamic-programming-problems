package CoinExchange;

import java.util.Arrays;

public class CoinExchange {

    public int findMinCoins(int[]coins, int total) {
        
        int[] amounts = new int[total + 1];
        Arrays.fill(amounts, total + 1);
        amounts[0] = 0; // BASE CASE

        for (int currAmount = 0; currAmount <= total; currAmount++) {
            for (int coin : coins) {
                if ((currAmount - coin) >= 0)
                    amounts[currAmount] = Math.min(1 + amounts[currAmount - coin], amounts[currAmount]);
            }
        }

        System.out.println(Arrays.toString(amounts));
        return amounts[total];
    }

    public static void main(String[] args) {
        int[] coins = { 2, 5, 6};
        int amount = 15;
        CoinExchange ce = new CoinExchange();
        int minCoins = ce.findMinCoins(coins, amount);
        System.out.println(minCoins);

    }
}
