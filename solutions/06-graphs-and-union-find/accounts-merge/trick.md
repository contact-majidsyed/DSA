# Accounts Merge: Quick Recall

**Trick:** Union emails within each account, then group emails by root. Same names without shared emails must stay separate.

**Key code:** `union(parent, size, account.get(1), email);`

**Looks like:** [Alex,x@e,y@e] and [Alex,y@e,z@e] -> component {x@e,y@e,z@e}.

**Remember:** Shared email joins accounts.

[Question](question.md) · [Java solution](Solution.java) · [Full explanation](explanation.md)

[Comment-only debug walkthrough](SolutionDebug.java)
