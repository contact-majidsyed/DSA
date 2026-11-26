# Design a Rate Limiter: Quick Recall

**Trick:** Make refill, quota check, and decrement one atomic operation; separate reads and writes let concurrent requests spend the same token.

**Key move:** Refill up to capacity, then subtract cost only if enough tokens remain.

**Looks like:** tokens=1; two simultaneous cost-1 requests -> only one may be allowed before refill.

**Remember:** One token cannot be spent twice.

[Question](question.md) · [Full approach](solution.md) · [Explanation](explanation.md)
