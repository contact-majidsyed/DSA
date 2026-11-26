# Design a URL Shortener: Quick Recall

**Trick:** Keep an authoritative code-to-URL mapping; cache redirects, and enforce unique codes during creation.

**Key move:** Persist a unique mapping before returning the short link.

**Looks like:** code abc -> https://example.com/article; cache miss -> mapping store -> cache fill -> redirect.

**Remember:** Unique on write; cached on read.

[Question](question.md) · [Full approach](solution.md) · [Explanation](explanation.md)
