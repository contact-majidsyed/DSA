package practice.dynamic_programming.coin_change;

import java.util.*;

/** Coin Change. See explanation.md for the contract and walkthrough. */
public class SolutionDebug {
    // COMMENT-ONLY DEBUG WALKTHROUGH: examples from question.md.
    // Example 1:
    //   Input: coins = [1,2,5], amount = 11
    //   Output: 3
    // Example 2:
    //   Input: coins = [2], amount = 3
    //   Output: -1
    // Inline values trace Example 1 unless Example 2 is named.
    // Each table row belongs to one visit; comments do not execute.
    // LOOP START/END labels mark source boundaries, not runtime statements.
    // return exits the method; continue skips to the next visit; break leaves its loop.
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // START amount=11: fill all 12 slots with unreachable sentinel 12.
        Arrays.fill(dp, amount + 1);
        // AFTER assignment: dp=[0,12,12,12,12,12,12,12,12,12,12,12].
        dp[0] = 0;
        // ===== LOOP START L1: for loop =====
        for (int value = 1; value <= amount; value++) {
            // INNER VISITS for every amount: coin=1,2,5. Skip coins larger than value.
            // ===== LOOP START L2: for loop =====
            for (int coin : coins) {
                // At value=5: coin1 proposes dp[4]+1=3; coin2 proposes dp[3]+1=3; coin5 proposes dp[0]+1=1.
                // AFTER each full outer visit value=1..11: dp[value]=1,1,2,2,1,2,2,3,3,2,3.
                if (coin <= value) dp[value] = Math.min(dp[value], dp[value - coin] + 1);
            }
            // ===== LOOP END L2 =====
        }
        // ===== LOOP END L1 =====
        // RETURN dp[11]=3. Example 2 coins=[2],amount=3 leaves dp[3]=4 (unreachable) -> -1.
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
