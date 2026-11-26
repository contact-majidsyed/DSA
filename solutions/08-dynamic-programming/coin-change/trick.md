# Coin Change: Quick Recall

**Trick:** Try each positive coin as the last coin for each amount; seed dp[0]=0 and mark other amounts unreachable.

**Key code:** `if (coin <= value) dp[value] = Math.min(dp[value], dp[value - coin] + 1);`

**Looks like:** coins=[1,2,5]: dp[5]=1, dp[10]=2, dp[11]=3 -> 5+5+1.

**Remember:** One coin plus the solved remainder.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)
