class Solution {

    public int coinChange(int amount, int[] coins, int index, int[][] dp) {

        if (amount == 0) return 1;

        if (index < 0) return 0;

        if (dp[index][amount] != -1)
            return dp[index][amount];

        int notPick = coinChange(amount, coins, index - 1, dp);

        int pick = 0;

        if (coins[index] <= amount) {
            pick = coinChange(
                amount - coins[index],
                coins,
                index,
                dp
            );
        }

        return dp[index][amount] = pick + notPick;
    }

    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return coinChange(amount, coins, coins.length - 1, dp);
    }
}